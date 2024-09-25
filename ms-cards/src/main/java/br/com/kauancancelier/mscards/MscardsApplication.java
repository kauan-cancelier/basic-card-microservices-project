package br.com.kauancancelier.mscards;

import br.com.kauancancelier.mscards.application.domain.Card;
import br.com.kauancancelier.mscards.application.domain.CardFlag;
import br.com.kauancancelier.mscards.application.infra.CardRepository;
import br.com.kauancancelier.mscards.application.infra.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;

@SpringBootApplication
public class MscardsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MscardsApplication.class, args);
    }

}
