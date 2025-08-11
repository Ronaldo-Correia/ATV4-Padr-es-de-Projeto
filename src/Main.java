public class Main {

    public static void main(String[] args) {
    dispositivoFactory factory = new dispositivoFactory() {
        @Override
        public dispositivo createDispositivo(String tipo, String nome) {
            if (tipo.equalsIgnoreCase("Atuador")) {
                return new Atuador(nome);
            }
            if (tipo.equalsIgnoreCase("Sensor")) {
                return new Sensor(nome);
            }
            throw new IllegalArgumentException("Tipo de dispositivo desconhecido: " + tipo);
        }
    };
    }
}