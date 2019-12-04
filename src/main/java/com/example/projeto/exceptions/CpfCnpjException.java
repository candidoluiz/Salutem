package com.example.projeto.exceptions;

public class CpfCnpjException extends Exception {

    public CpfCnpjException(String cpfCnpj) {
        super("Formato inválido: " + cpfCnpj);
    }

    public CpfCnpjException(String cpfCnpj, Long id){
        super("O documento informado ja se encontra cadastrado" + "\n"+cpfCnpj);
    }
}
