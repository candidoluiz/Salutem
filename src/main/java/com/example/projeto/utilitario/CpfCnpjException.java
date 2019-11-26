package com.example.projeto.utilitario;

public class CpfCnpjException extends Exception {

    public CpfCnpjException(String cpfCnpj) {
        super("Formato inválido: " + cpfCnpj);
    }
}
