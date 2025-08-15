package br.edu.ifba.iot.core.devices.types;

import br.edu.ifba.iot.core.devices.Actuator;
import br.edu.ifba.iot.core.devices.Device;
import br.edu.ifba.iot.core.dispositivo;

public class FanActuator extends Device implements Actuator, dispositivo {
    private boolean on = false;
    private int level = 0;

    public FanActuator(String name) { super(name); }

    // dispositivo
    @Override public void ligar() { turnOn(); }
    @Override public void desligar() { turnOff(); }
    @Override public String getNome() { return getName(); }

    // Actuator
    @Override public void turnOn() { on = true; }
    @Override public void turnOff() { on = false; level = 0; }
    @Override public void setLevel(int level) {
        this.level = Math.max(0, Math.min(100, level));
        on = this.level > 0;
    }
    @Override public boolean isOn() { return on; }
    @Override public int getLevel() { return level; }
}
