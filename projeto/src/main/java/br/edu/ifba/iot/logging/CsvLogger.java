package br.edu.ifba.iot.logging;

public class CsvLogger implements Logger {
    @Override
    public void info(String message) {
        System.out.println("INFO;" + message.replace(";", ","));
    }

    @Override
    public void error(String message, Throwable t) {
        System.err.println("ERROR;" + message.replace(";", ",") + ";" + t);
    }
}