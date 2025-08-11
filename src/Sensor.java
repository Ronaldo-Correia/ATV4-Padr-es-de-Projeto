public class Sensor implements dispositivo {
    private String nome;

    public Sensor(String nome) {
        this.nome = nome;
    }

    @Override
    public void ligar() {
        System.out.println("Sensor " + nome + " ligado.");
    }

    @Override
    public void desligar() {
        System.out.println("Sensor " + nome + " desligado.");
    }

    @Override
    public String getNome() {
        return nome;
    }
}
