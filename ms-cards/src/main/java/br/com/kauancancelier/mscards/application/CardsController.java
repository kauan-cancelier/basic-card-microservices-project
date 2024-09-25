package br.com.kauancancelier.mscards.application;

import br.com.kauancancelier.mscards.application.domain.Card;
import br.com.kauancancelier.mscards.application.domain.CardClient;
import br.com.kauancancelier.mscards.application.infra.service.CardClientService;
import br.com.kauancancelier.mscards.application.infra.service.CardService;
import br.com.kauancancelier.mscards.application.representation.CardByClient;
import br.com.kauancancelier.mscards.application.representation.CardSaveRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("cards")
@Slf4j
@RequiredArgsConstructor
public class CardsController {

    private final CardService cardService;

    private final CardClientService cardClientService;

    @GetMapping("/status")
    public String status() {
        log.info("Cards status OK");
        return "OK";
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CardSaveRequest card) {
        log.info("Cards creating");
        Card model = card.toModel();
        cardService.save(model);
        return ResponseEntity.status(201).body(model);
    }

    @GetMapping
    public ResponseEntity<List<Card>> listCards(@RequestParam("income") Long income) {
        List<Card> cards = cardService.listCardsEqualsLowerThan(income);
        return ResponseEntity.ok(cards);
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<List<CardByClient>> listCardByClients(@RequestParam("cpf") String cpf) {
        List<CardClient> cardClientList = cardClientService.findByCpf(cpf);
        List<CardByClient> cardByClientsList = cardClientList
                .stream()
                .map(CardByClient::fromModel)
                .toList();
        return ResponseEntity.ok(cardByClientsList);
    }


}
