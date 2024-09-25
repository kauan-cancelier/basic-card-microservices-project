package br.com.kauancancelier.mscreditassessor.domain.representation;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AceptedCard {
    private String card;
    private String flag;
    private BigDecimal creditLimit;

}
