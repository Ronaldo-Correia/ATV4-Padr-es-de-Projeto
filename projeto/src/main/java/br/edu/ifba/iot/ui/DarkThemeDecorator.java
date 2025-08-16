package br.edu.ifba.iot.ui;

public class DarkThemeDecorator extends ThemeDecorator {
    public DarkThemeDecorator(ViewComponent inner) {
        super(inner);
    }

    @Override
    public String render() {
        return "[DARK THEME]\n" + inner.render();
    }
}