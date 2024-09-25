package br.com.kauancancelier.mscreditassessor.domain.representation;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AssessClientReturn {
    private List<AceptedCard> cards;

}
