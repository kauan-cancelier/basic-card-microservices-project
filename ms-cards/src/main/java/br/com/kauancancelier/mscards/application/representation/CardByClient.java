package br.com.kauancancelier.mscards.application.representation;

import br.com.kauancancelier.mscards.application.domain.CardClient;
import br.com.kauancancelier.mscards.application.domain.CardFlag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardByClient {

    private String name;
    private CardFlag flag;;
    private BigDecimal creditLimit;

    public static CardByClient fromModel(CardClient client) {
        return new CardByClient(
                client.getCard().getName(),
                client.getCard().getFlag(),
                client.getCard().getCreditLimit()
        );
    }

}
