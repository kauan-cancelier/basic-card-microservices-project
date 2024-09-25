package br.com.kauancancelier.mscreditassessor.domain.representation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientStatus {
    private ClientData cliente;
    private List<ClientCard> cards;


}
