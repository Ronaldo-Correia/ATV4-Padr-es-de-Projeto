package br.edu.ifba.iot.factory;

import br.edu.ifba.iot.core.devices.Actuator;
import br.edu.ifba.iot.core.devices.Sensor;
import br.edu.ifba.iot.core.devices.types.FanActuator;
import br.edu.ifba.iot.core.devices.types.LightBulbActuator;
import br.edu.ifba.iot.core.devices.types.LightSensor;
import br.edu.ifba.iot.core.devices.types.TemperatureSensor;

public class DefaultDeviceFactory implements DeviceFactory {
    @Override public Sensor createTemperatureSensor(String name) { return new TemperatureSensor(name); }
    @Override public Sensor createLightSensor(String name) { return new LightSensor(name); }
    @Override public Actuator createFan(String name) { return new FanActuator(name); }
    @Override public Actuator createLightBulb(String name) { return new LightBulbActuator(name); }
}