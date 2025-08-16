package br.edu.ifba.iot.ui;

public class Label implements ViewComponent {
    private final String text;

    public Label(String text) {
        this.text = text;
    }

    @Override
    public String render() {
        return "- " + text;
    }
}