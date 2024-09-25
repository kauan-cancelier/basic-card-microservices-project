package br.com.kauancancelier.mscreditassessor.infra.clients;

import br.com.kauancancelier.mscreditassessor.domain.representation.ClientData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "clientsms", path = "/clients")
public interface ClientResourceClient {

    @GetMapping(params = "cpf")
    ResponseEntity<ClientData> clientByCpf(@RequestParam String cpf);
}
