package br.edu.ifba.iot.ui;

public abstract class ThemeDecorator implements ViewComponent {
    protected final ViewComponent inner;

    public ThemeDecorator(ViewComponent inner) {
        this.inner = inner;
    }
}