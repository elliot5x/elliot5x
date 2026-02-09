import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // A Main apenas "apresenta" o Scanner ao Menu
        Menu iniciarMenu = new Menu();
        iniciarMenu.menu(sc);
        
        sc.close();
    }
}

class Menu {
    public void menu(Scanner sc) {
        while (true) {
            try {
                System.out.println("\n==== THE MENU ====");
                System.out.print("1. Jogar\n2. Sair\n>> ");
                
                int escolha = sc.nextInt();
                sc.nextLine(); // Limpa o "Enter" que sobra do nextInt()

                if (escolha == 1) {
                    System.out.print("Digite seu nome para o jogo: ");
                    String nomeParaOJogador = sc.nextLine();
                    decisoesMenu(escolha, nomeParaOJogador);
                } else {
                    decisoesMenu(escolha, "");
                }

            } catch (Exception e) {
                System.out.println("Erro: Digite apenas números.");
                sc.next(); 
            }
        }
    }

    public void decisoesMenu(int opcao, String nomeEnviado) {
        Jogo iniciarJogo = new Jogo();

        switch (opcao) {
            case 1 -> System.out.println(iniciarJogo.jogo(nomeEnviado));
            case 2 -> {
                System.out.println("Saindo...");
                System.exit(0);
            }
            default -> System.out.println("Opção inválida.");
        }
    }
}

class Jogo {
    // O método agora espera receber uma String para funcionar
    public String jogo(String nomeRecebido) {
        return "Hello World! Jogador atual: " + nomeRecebido;
    }
}
