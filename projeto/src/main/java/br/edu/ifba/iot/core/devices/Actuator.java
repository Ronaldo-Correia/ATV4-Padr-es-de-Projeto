package br.edu.ifba.iot.core.devices;

public interface Actuator {
    void turnOn();
    void turnOff();
    void setLevel(int level); // 0..100
    boolean isOn();
    int getLevel();
}