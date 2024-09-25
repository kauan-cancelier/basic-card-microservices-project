package br.com.kauancancelier.mscards.application.infra.service;

import br.com.kauancancelier.mscards.application.domain.CardClient;
import br.com.kauancancelier.mscards.application.infra.CardClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CardClientService {

    private final CardClientRepository cardClientRepository;

    public List<CardClient> findByCpf(String cpf) {
        return cardClientRepository.findByCpf(cpf);
    }

    public void save(CardClient cardClient) {
        cardClientRepository.save(cardClient);
    }

}
