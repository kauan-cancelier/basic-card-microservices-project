package br.com.kauancancelier.msclients.infra.repository;

import br.com.kauancancelier.msclients.domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("SELECT c FROM Client c WHERE c.cpf = :cpf")
    Optional<Client> findByCpf(String cpf);
}
