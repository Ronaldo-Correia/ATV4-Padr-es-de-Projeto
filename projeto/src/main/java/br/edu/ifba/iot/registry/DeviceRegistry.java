package br.edu.ifba.iot.registry;

import br.edu.ifba.iot.core.devices.Device;
import java.util.*;

public class DeviceRegistry {
    private final Map<String, Device> map = new HashMap<>();
    public void register(Device d) { map.put(d.getId(), d); }
    public Optional<Device> findById(String id) { return Optional.ofNullable(map.get(id)); }
    public Collection<Device> all() { return Collections.unmodifiableCollection(map.values()); }
}