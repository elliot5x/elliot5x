public class Main {
    public static void main(String[] args) {
        System.out.println("--- INÍCIO DO PROGRAMA (MAIN) ---");

        // 1. Criamos as peças independentes
        Motor motorV8 = new Motor("V8 Turbo", 800);
        Carro ferrari = new Carro("Ferrari", motorV8); // Passamos o motor para o carro
        Piloto piloto = new Piloto("Ayrton");

        // 2. A Main conecta o Piloto ao Carro
        piloto.entrarNoCarro(ferrari);

        // 3. A Main dá a ordem, e o efeito dominó começa
        piloto.iniciarCorrida();

        System.out.println("--- FIM DO PROGRAMA ---");
    }
}

// --- CLASSE 1: O PILOTO (Quem comanda o Carro) ---
class Piloto {
    String nome;
    Carro carroAtual; // O piloto tem um espaço para guardar um objeto Carro

    public Piloto(String nome) {
        this.nome = nome;
    }

    public void entrarNoCarro(Carro carro) {
        this.carroAtual = carro; // Conexão feita!
        System.out.println("Piloto " + this.nome + " entrou na " + carro.modelo);
    }

    public void iniciarCorrida() {
        System.out.println(this.nome + ": 'Vamos nessa!'");
        // O Piloto chama um método de outra classe (Carro)
        carroAtual.ligar(); 
        carroAtual.acelerar();
    }
}

// --- CLASSE 2: O CARRO (Quem comanda o Motor) ---
class Carro {
    String modelo;
    Motor motor; // O Carro tem um objeto Motor dentro dele

    public Carro(String modelo, Motor motor) {
        this.modelo = modelo;
        this.motor = motor; // Conexão feita!
    }

    public void ligar() {
        System.out.println("O carro " + this.modelo + " está girando a chave...");
        // O Carro chama um método de outra classe (Motor)
        motor.darPartida(); 
    }

    public void acelerar() {
        System.out.println(this.modelo + " está ganhando velocidade!");
        motor.aumentarRotacao(); // Chama o motor de novo
    }
}

// --- CLASSE 3: O MOTOR (A peça final que executa) ---
class Motor {
    String tipo;
    int cavalos;

    public Motor(String tipo, int cavalos) {
        this.tipo = tipo;
        this.cavalos = cavalos;
    }

    public void darPartida() {
        System.out.println("   -> MOTOR [" + tipo + "]: VRUMMMM! (Ligado)");
    }

    public void aumentarRotacao() {
        System.out.println("   -> MOTOR: Aumentando potência para " + cavalos + "cv!");
    }
}
