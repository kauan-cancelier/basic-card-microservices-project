package br.com.kauancancelier.mscards.application.infra;

import br.com.kauancancelier.mscards.application.domain.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {

    @Query("SELECT c FROM Card c WHERE c.income <= :income")
    List<Card> byCardsLessThanEqual(BigDecimal income);
}
