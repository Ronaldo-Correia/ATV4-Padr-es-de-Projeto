package br.edu.ifba.iot.factory;
import java.util.Properties;
import java.io.InputStream;

import br.edu.ifba.iot.config.ConfigManager; 

public class FactoryProvider {
    // Factory Method para escolher qual fábrica concreta usar (por vendor/tema/etc.)
    public static DeviceFactory getFactory() {
        String vendor = ConfigManager.getInstance().get("vendor");
        // Poderia haver: if ("acme".equals(vendor)) return new AcmeFactory();
        return new DefaultDeviceFactory();
    }
}