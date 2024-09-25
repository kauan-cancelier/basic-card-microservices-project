package br.com.kauancancelier.msclients.application.representation;

import br.com.kauancancelier.msclients.domain.Client;
import lombok.Data;

@Data
public class ClientSaveRequest {

    private String name;
    private Integer age;
    private String cpf;

    public Client toModel() {
        return new Client(name, age, cpf);
    }
}
