package br.edu.ifba.iot.strategy;

public class RespostaComAtraso implements EstrategiaResposta {
    @Override
    public void executar() {
        System.out.println("Executando resposta com atraso...");
    }
}