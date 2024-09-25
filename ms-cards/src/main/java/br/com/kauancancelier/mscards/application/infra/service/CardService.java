package br.com.kauancancelier.mscards.application.infra.service;

import br.com.kauancancelier.mscards.application.domain.Card;
import br.com.kauancancelier.mscards.application.infra.CardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CardService {

    private final CardRepository cardRepository;

    @Transactional
    public Card save(Card card) {
        return cardRepository.save(card);
    }

    public List<Card> listCardsEqualsLowerThan(Long income) {
        var incomeBigDecimal = BigDecimal.valueOf(income);
        return cardRepository.byCardsLessThanEqual(incomeBigDecimal);
    }

}
