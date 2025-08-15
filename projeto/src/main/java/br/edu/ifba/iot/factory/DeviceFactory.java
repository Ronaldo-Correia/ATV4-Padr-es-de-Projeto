package br.edu.ifba.iot.factory;

import br.edu.ifba.iot.core.devices.Actuator;
import br.edu.ifba.iot.core.devices.Sensor;

public interface DeviceFactory {
    Sensor createTemperatureSensor(String name);
    Sensor createLightSensor(String name);
    Actuator createFan(String name);
    Actuator createLightBulb(String name);
}