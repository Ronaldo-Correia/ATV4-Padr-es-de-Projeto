package br.edu.ifba.iot.ui;

public class LightThemeDecorator extends ThemeDecorator {
    public LightThemeDecorator(ViewComponent inner) {
        super(inner);
    }

    @Override
    public String render() {
        return "[LIGHT THEME]\n" + inner.render();
    }
}