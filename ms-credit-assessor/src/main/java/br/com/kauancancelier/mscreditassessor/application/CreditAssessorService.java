package br.com.kauancancelier.mscreditassessor.application;

import br.com.kauancancelier.mscreditassessor.application.ex.ClientCommunicationException;
import br.com.kauancancelier.mscreditassessor.application.ex.ClientDataNotFoundException;
import br.com.kauancancelier.mscreditassessor.domain.representation.*;
import br.com.kauancancelier.mscreditassessor.infra.clients.CardsResourceClient;
import br.com.kauancancelier.mscreditassessor.infra.clients.ClientResourceClient;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CreditAssessorService {

    private final ClientResourceClient clientsClient;

    private final CardsResourceClient cardsClient;


    public ClientStatus getClientStatusBy(String cpf) throws ClientDataNotFoundException, ClientCommunicationException {
        try {
            ResponseEntity<ClientData> clientResponse = clientsClient.clientByCpf(cpf);
            ResponseEntity<List<ClientCard>> clientCardsResponse = cardsClient.listCardByClients(cpf);

            return ClientStatus.builder()
                    .cliente(clientResponse.getBody())
                    .cards(clientCardsResponse.getBody())
                    .build();
        } catch(FeignException.FeignClientException e) {
            int status = e.status();
            if (HttpStatus.NOT_FOUND.value() == status) {
                throw new ClientDataNotFoundException();
            }
            throw new ClientCommunicationException(e.getMessage(), status);
        }
    }

    public AssessClientReturn toAssess(String cpf, Long income) throws ClientDataNotFoundException, ClientCommunicationException {
        try {
            ResponseEntity<ClientData> clientResponse = clientsClient.clientByCpf(cpf);
            ResponseEntity<List<Card>> cards = cardsClient.listCards(income);

            List<Card> body = cards.getBody();

            var list = body.stream().map(card -> {
                ClientData clientData = clientResponse.getBody();

                BigDecimal creditLimit = card.getCreditLimit();
                BigDecimal rendaBD = BigDecimal.valueOf(income);
                BigDecimal age = BigDecimal.valueOf(clientData.getAge());

                BigDecimal factor = age.divide(BigDecimal.valueOf(10));
                BigDecimal aceptedLimit = factor.multiply(creditLimit);

                AceptedCard aceptedCard = new AceptedCard();
                aceptedCard.setCard(card.getName());
                aceptedCard.setFlag(card.getFlag());
                aceptedCard.setCreditLimit(aceptedLimit);

                return aceptedCard;
            }).collect(Collectors.toList());

            return new AssessClientReturn(list);

        } catch(FeignException.FeignClientException e) {
            int status = e.status();
            if (HttpStatus.NOT_FOUND.value() == status) {
                throw new ClientDataNotFoundException();
            }
            throw new ClientCommunicationException(e.getMessage(), status);
        }
    }



}
