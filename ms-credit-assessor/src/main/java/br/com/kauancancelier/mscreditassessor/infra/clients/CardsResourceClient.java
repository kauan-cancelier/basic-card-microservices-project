package br.com.kauancancelier.mscreditassessor.infra.clients;

import br.com.kauancancelier.mscreditassessor.domain.representation.Card;
import br.com.kauancancelier.mscreditassessor.domain.representation.ClientCard;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(value = "mscards", path = "/cards")
public interface CardsResourceClient {

    @GetMapping(params = "cpf")
    ResponseEntity<List<ClientCard>> listCardByClients(@RequestParam("cpf") String cpf);

    @GetMapping
    public ResponseEntity<List<Card>> listCards(@RequestParam("income") Long income);

}
