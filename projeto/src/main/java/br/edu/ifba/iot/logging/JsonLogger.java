package br.edu.ifba.iot.logging;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

public class JsonLogger implements Logger {
    private final Gson gson = new Gson();

    @Override
    public void info(String message) {
        Map<String, String> log = new HashMap<>();
        log.put("level", "INFO");
        log.put("message", message);
        System.out.println(gson.toJson(log));
    }

    @Override
    public void error(String message, Throwable t) {
        Map<String, String> log = new HashMap<>();
        log.put("level", "ERROR");
        log.put("message", message);
        log.put("exception", t.toString());
        System.err.println(gson.toJson(log));
    }
}