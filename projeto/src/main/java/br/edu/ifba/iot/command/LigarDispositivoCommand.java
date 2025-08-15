package br.edu.ifba.iot.command;

import br.edu.ifba.iot.core.dispositivo;

public class LigarDispositivoCommand implements Command {
    private final dispositivo dispositivo;

    public LigarDispositivoCommand(dispositivo dispositivo) {
        this.dispositivo = dispositivo;
    }

    @Override
    public void executar() {
        dispositivo.ligar();
        System.out.println(dispositivo.getNome() + " ligado!");
    }
}
