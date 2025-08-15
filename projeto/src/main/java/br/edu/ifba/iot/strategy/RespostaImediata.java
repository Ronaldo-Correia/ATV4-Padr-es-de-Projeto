package br.edu.ifba.iot.strategy;

public class RespostaImediata implements EstrategiaResposta {
    @Override
    public void executar() {
        System.out.println("Executando resposta imediata...");
    }
}