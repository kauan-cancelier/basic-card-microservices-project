package br.com.kauancancelier.mscreditassessor.application.ex;

public class ClientDataNotFoundException extends Exception {

    public ClientDataNotFoundException() {
        super("Client data not found");
    }
}
