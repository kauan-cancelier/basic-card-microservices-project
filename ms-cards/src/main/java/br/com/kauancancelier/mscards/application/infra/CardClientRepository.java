package br.com.kauancancelier.mscards.application.infra;

import br.com.kauancancelier.mscards.application.domain.CardClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CardClientRepository extends JpaRepository<CardClient, Long> {

    @Query("SELECT c FROM CardClient c WHERE c.cpf = :cpf")
    List<CardClient> findByCpf(String cpf);

}
