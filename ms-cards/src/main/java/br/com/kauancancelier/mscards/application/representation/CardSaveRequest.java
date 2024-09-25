package br.com.kauancancelier.mscards.application.representation;

import br.com.kauancancelier.mscards.application.domain.Card;
import br.com.kauancancelier.mscards.application.domain.CardFlag;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CardSaveRequest {

    private String name;
    private CardFlag flag;
    private BigDecimal income;
    private BigDecimal limit;

    public Card toModel() {
        return  new Card(name, flag, income, limit);
    }

}
