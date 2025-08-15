package br.edu.ifba.iot.core.devices.types;

import br.edu.ifba.iot.core.devices.Device;
import br.edu.ifba.iot.core.devices.Sensor;

public class LightSensor extends Device implements Sensor {
    private double lux = 300.0;
    public LightSensor(String name) { super(name); }
    public void setLux(double lux) { this.lux = lux; }
    @Override public double read() { return lux; }
}