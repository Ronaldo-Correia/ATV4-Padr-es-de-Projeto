package br.edu.ifba.iot.core.devices.types;

import br.edu.ifba.iot.core.devices.Device;
import br.edu.ifba.iot.core.devices.Sensor;

public class TemperatureSensor extends Device implements Sensor {
    private double current = 25.0; // simulado
    public TemperatureSensor(String name) { super(name); }
    public void setCurrent(double c) { this.current = c; }
    @Override public double read() { return current; }
}