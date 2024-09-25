package br.com.kauancancelier.msclients.application;

import br.com.kauancancelier.msclients.domain.Client;
import br.com.kauancancelier.msclients.infra.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository repository;

    public Client save(Client client) {
        return repository.save(client);
    }

    public Optional<Client> findByCPF(String cpf) {
        return repository.findByCpf(cpf);
    }
}
