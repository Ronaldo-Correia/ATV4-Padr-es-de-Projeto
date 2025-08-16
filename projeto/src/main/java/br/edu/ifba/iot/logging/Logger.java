package br.edu.ifba.iot.logging;

public interface Logger {
    void info(String message);

    void error(String message, Throwable t);
}