package br.edu.ifba.iot;

import br.edu.ifba.iot.command.*;
import br.edu.ifba.iot.core.dispositivo;
import br.edu.ifba.iot.core.devices.types.LightBulbActuator;
import br.edu.ifba.iot.core.events.*;

public class Main {
    public static void main(String[] args) {
        // ===== Parte do Command =====
        dispositivo lampada = new LightBulbActuator("Lâmpada da sala");

        Command ligar = new LigarDispositivoCommand(lampada);
        Command desligar = new DesligarDispositivoCommand(lampada);

        ligar.executar();
        desligar.executar();

        // ===== Parte do Observer =====
        EventManager eventManager = new EventManager();

        // Inscrevendo um listener de log
        eventManager.subscribe(new LogEventListener());

        // Simulando um evento vindo de um sensor
        Event eventoLuz = new Event(EventType.LIGHT, "sensor_luz_1", 75.0, "Luminosidade detectada");
        eventManager.publish(eventoLuz);

        Event eventoTemp = new Event(EventType.TEMPERATURE, "sensor_temp_1", 28.5, "Temperatura acima do normal");
        eventManager.publish(eventoTemp);
    }
}
