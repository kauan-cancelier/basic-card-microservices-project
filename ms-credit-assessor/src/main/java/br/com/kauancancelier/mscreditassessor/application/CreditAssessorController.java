package br.com.kauancancelier.mscreditassessor.application;

import br.com.kauancancelier.mscreditassessor.application.ex.ClientCommunicationException;
import br.com.kauancancelier.mscreditassessor.application.ex.ClientDataNotFoundException;
import br.com.kauancancelier.mscreditassessor.domain.representation.AssessClientReturn;
import br.com.kauancancelier.mscreditassessor.domain.representation.AssessData;
import br.com.kauancancelier.mscreditassessor.domain.representation.ClientStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("credit-assessor")
@RequiredArgsConstructor
public class CreditAssessorController {

    private final CreditAssessorService service;

    @GetMapping
    public String status() {
        return "OK";
    }

    @GetMapping(value = "client-status", params = "cpf")
    public ResponseEntity<?> clientStatus(@RequestParam("cpf") String cpf){
        try {
            ClientStatus clientStatus = service.getClientStatusBy(cpf);
            return ResponseEntity.ok(clientStatus);
        } catch (ClientDataNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (ClientCommunicationException e) {
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity toAssess(@RequestBody AssessData data) {
        try {
            AssessClientReturn assess = service.toAssess(data.getCpf(), data.getIncome());
            return ResponseEntity.ok(assess);
        } catch (ClientDataNotFoundException e) {
            return ResponseEntity.notFound().build();
        } catch (ClientCommunicationException e) {
            return ResponseEntity.status(e.getStatus()).body(e.getMessage());
        }

    }


}
