package br.edu.ifba.iot.logging;

public class PlainLogger implements Logger {
    @Override
    public void info(String message) {
        System.out.println("[INFO] " + message);
    }

    @Override
    public void error(String message, Throwable t) {
        System.err.println("[ERROR] " + message);
        t.printStackTrace();
    }
}