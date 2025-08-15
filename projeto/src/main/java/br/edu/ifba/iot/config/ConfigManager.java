// src/main/java/br/edu/ifba/iot/config/ConfigManager.java
package br.edu.ifba.iot.config;

import java.util.HashMap;
import java.util.Map;

public class ConfigManager {
    private static ConfigManager instance;
    private Map<String, String> settings = new HashMap<>();

    private ConfigManager() {
        // configuração padrão
        settings.put("delayStrategy.ms", "2000");
    }

    public static synchronized ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }

    public void set(String key, String value) {
        settings.put(key, value);
    }

    public String get(String key) {
        return settings.get(key);
    }
}
