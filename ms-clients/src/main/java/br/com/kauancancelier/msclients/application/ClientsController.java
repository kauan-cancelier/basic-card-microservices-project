package br.com.kauancancelier.msclients.application;

import br.com.kauancancelier.msclients.application.representation.ClientSaveRequest;
import br.com.kauancancelier.msclients.domain.Client;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/clients")
@RequiredArgsConstructor
@Slf4j
public class ClientsController {

    private final ClientService clientService;

    @GetMapping
    public String status() {
        log.info("Obtendo o status do microsserviço de clientes");
        return "OK";
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody ClientSaveRequest request) {
        Client model = request.toModel();
        clientService.save(model);
        URI headerLocation = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .query("cpf={cpf}")
                .buildAndExpand(model.getCpf())
                .toUri();
        return ResponseEntity.created(headerLocation).build();
    }

    @GetMapping(params = "cpf")
    public ResponseEntity<Client> clientByCpf(@RequestParam String cpf) {
        Optional<Client> client = clientService.findByCPF(cpf);
        if (client.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(client.get());
    }

}
