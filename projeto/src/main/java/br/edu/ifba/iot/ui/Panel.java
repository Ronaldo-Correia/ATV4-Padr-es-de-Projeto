package br.edu.ifba.iot.ui;

import java.util.ArrayList;
import java.util.List;

public class Panel implements ViewComponent {
    private final List<ViewComponent> children = new ArrayList<>();

    public void add(ViewComponent component) {
        children.add(component);
    }

    @Override
    public String render() {
        StringBuilder sb = new StringBuilder("=== Panel ===\n");
        for (ViewComponent c : children) {
            sb.append(c.render()).append("\n");
        }
        return sb.toString();
    }
}