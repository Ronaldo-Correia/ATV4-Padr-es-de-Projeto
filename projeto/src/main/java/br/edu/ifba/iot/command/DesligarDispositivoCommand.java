package br.edu.ifba.iot.command;

import br.edu.ifba.iot.core.dispositivo;

public class DesligarDispositivoCommand implements Command {
    private final dispositivo dispositivo;

    public DesligarDispositivoCommand(dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    @Override
    public void executar() {
        dispositivo.desligar();
        System.out.println(dispositivo.getNome() + " desligado!");
    }
}
