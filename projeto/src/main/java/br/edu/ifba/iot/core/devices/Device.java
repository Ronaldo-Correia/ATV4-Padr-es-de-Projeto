package br.edu.ifba.iot.core.devices;

import java.util.UUID;

public abstract class Device {
    private final String id = UUID.randomUUID().toString();
    private final String name;

    protected Device(String name) { this.name = name; }

    public String getId() { return id; }
    public String getName() { return name; }
}