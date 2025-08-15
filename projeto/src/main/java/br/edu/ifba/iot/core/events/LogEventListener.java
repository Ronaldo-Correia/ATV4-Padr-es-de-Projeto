package br.edu.ifba.iot.core.events;

public class LogEventListener implements EventListener {
    @Override
    public void onEvent(Event event) {
        System.out.println("[LOG] Evento recebido: " + event);
    }
}