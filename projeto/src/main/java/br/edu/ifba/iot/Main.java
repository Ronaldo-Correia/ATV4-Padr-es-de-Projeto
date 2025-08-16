package br.edu.ifba.iot;

import br.edu.ifba.iot.command.*;
import br.edu.ifba.iot.config.ConfigManager;
import br.edu.ifba.iot.core.dispositivo;
import br.edu.ifba.iot.core.devices.Device;
import br.edu.ifba.iot.core.devices.Sensor;
import br.edu.ifba.iot.core.devices.Actuator;
import br.edu.ifba.iot.core.devices.types.LightBulbActuator;
import br.edu.ifba.iot.core.events.*;
import br.edu.ifba.iot.factory.DeviceFactory;
import br.edu.ifba.iot.factory.FactoryProvider;
import br.edu.ifba.iot.registry.DeviceRegistry;
import br.edu.ifba.iot.strategy.*;
import br.edu.ifba.iot.ui.*;
import br.edu.ifba.iot.logging.*;

public class Main {
    public static void main(String[] args) {
        // ===== Singleton (ConfigManager) =====
        ConfigManager cfg = ConfigManager.getInstance();
        cfg.set("vendor", "default");
        System.out.println("[CONFIG] Singleton ativo. vendor=" + cfg.get("vendor")
                + ", delayStrategy.ms=" + cfg.get("delayStrategy.ms"));

        // ===== Factory + Registry (cadastro de dispositivos) =====
        DeviceFactory factory = FactoryProvider.getFactory();
        Sensor tempSensor = factory.createTemperatureSensor("Sensor de Temperatura (Cozinha)");
        Sensor lightSensor = factory.createLightSensor("Sensor de Luz (Sala)");
        Actuator fan = factory.createFan("Ventilador (Sala)");
        Actuator bulbFromFactory = factory.createLightBulb("Lâmpada (Quarto)");

        DeviceRegistry registry = new DeviceRegistry();
        registry.register((Device) tempSensor);
        registry.register((Device) lightSensor);
        registry.register((Device) fan);
        registry.register((Device) bulbFromFactory);

        dispositivo lampada = new LightBulbActuator("Lâmpada da sala");
        registry.register((Device) lampada);

        System.out.println("[FACTORY/REGISTRY] Dispositivos cadastrados:");
        for (Device d : registry.all()) {
            System.out.printf(" - %s: %s (ID: %s)%n",
                    d.getClass().getSimpleName(), d.getName(), d.getId());
        }

        // ===== Command (ligar/desligar) =====
        Command ligar = new LigarDispositivoCommand(lampada);
        Command desligar = new DesligarDispositivoCommand(lampada);
        ligar.executar();
        desligar.executar();

        // ===== Observer (eventos) =====
        EventManager eventManager = new EventManager();
        eventManager.subscribe(new LogEventListener());

        String lightId = ((Device) lightSensor).getId();
        String tempId = ((Device) tempSensor).getId();

        Event eventoLuz = new Event(EventType.LIGHT, lightId, 75.0, "Luminosidade detectada");
        Event eventoTemp = new Event(EventType.TEMPERATURE, tempId, 28.5, "Temperatura acima do normal");

        eventManager.publish(eventoLuz);
        eventManager.publish(eventoTemp);

        // ===== Strategy (resposta aos eventos) =====
        EstrategiaResposta imediata = new RespostaImediata();
        EstrategiaResposta validada = new RespostaValidada();
        EstrategiaResposta comAtraso = new RespostaComAtraso();

        // Regra: temperatura > 30°C => ligar ventilador (validada), senão imediata
        dispositivo ventiladorAsDisp = (dispositivo) fan; // FanActuator implementa 'dispositivo'
        if (eventoTemp.value() > 30.0) {
            System.out.println("[STRATEGY] Temperatura > 30°C → aplicar RespostaValidada e ligar ventilador");
            validada.executar();
            new LigarDispositivoCommand(ventiladorAsDisp).executar();
        } else {
            System.out.println("[STRATEGY] Temperatura <= 30°C → aplicar RespostaImediata (sem ação)");
            imediata.executar();
        }

        // Regra: baixa luminosidade (< 100 lux) => ligar lâmpada com atraso
        if (eventoLuz.value() < 100.0) {
            System.out.println("[STRATEGY] Baixa luminosidade → aplicar RespostaComAtraso e ligar lâmpada da sala");
            comAtraso.executar();
            new LigarDispositivoCommand(lampada).executar();
        }

        // ===== Logging em múltiplos formatos =====
        Logger plain = new PlainLogger();
        Logger json = new JsonLogger();
        Logger csv = new CsvLogger();

        plain.info("Sistema iniciado.");
        json.info("Evento recebido do sensor de luz.");
        csv.error("Falha ao conectar dispositivo.", new RuntimeException("Timeout"));

        // ===== UI (Composite + Decorator) =====
        Panel panel = new Panel();
        panel.add(new Label("Evento: " + eventoLuz.payload() + " (" + eventoLuz.value() + " lux)"));
        panel.add(new Label("Evento: " + eventoTemp.payload() + " (" + eventoTemp.value() + " °C)"));
        panel.add(new Label(
                "Ação (temp): " + (eventoTemp.value() > 30.0 ? "Ligar ventilador (validada)" : "Sem ação (imediata)")));
        panel.add(new Label("Ação (luz): " + (eventoLuz.value() < 100.0 ? "Ligar lâmpada (com atraso)" : "Sem ação")));

        ViewComponent darkUI = new DarkThemeDecorator(panel);
        ViewComponent lightUI = new LightThemeDecorator(panel);

        System.out.println(darkUI.render());
        System.out.println(lightUI.render());
    }
}
