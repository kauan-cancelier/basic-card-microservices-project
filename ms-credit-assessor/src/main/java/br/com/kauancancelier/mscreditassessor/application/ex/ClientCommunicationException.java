package br.com.kauancancelier.mscreditassessor.application.ex;

import lombok.Getter;

public class ClientCommunicationException extends RuntimeException {

    @Getter
    private Integer status;

    public ClientCommunicationException(String message, Integer status) {
        super(message);
        this.status = status;
    }


}
