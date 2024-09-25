package br.com.kauancancelier.mscards.application.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Table
@Entity
@Data
@NoArgsConstructor
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private CardFlag flag;

    private BigDecimal income;

    @Column(name = "credit_limit", nullable = false)
    private BigDecimal creditLimit;

    public Card(String name, CardFlag flag, BigDecimal income, BigDecimal creditLimit) {
        this.name = name;
        this.flag = flag;
        this.income = income;
        this.creditLimit = creditLimit;
    }

}
