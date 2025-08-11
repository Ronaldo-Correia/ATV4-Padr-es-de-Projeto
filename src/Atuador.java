public class Atuador implements dispositivo {
    private String nome;

    public Atuador(String nome) {
        this.nome = nome;
    }

    @Override
    public void ligar() {
        System.out.println("Atuador " + nome + " ligado.");
    }

    @Override
    public void desligar() {
        System.out.println("Atuador " + nome + " desligado.");
    }
    
    @Override
    public String getNome() {
        return nome;
    }
}
