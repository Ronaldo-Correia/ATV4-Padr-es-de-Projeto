package br.edu.ifba.iot.strategy;

public class RespostaValidada implements EstrategiaResposta {
    @Override
    public void executar() {
        System.out.println("Executando resposta validada...");
    }
}