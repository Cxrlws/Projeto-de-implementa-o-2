import characters.Combat;
import characters.Character;
import java.util.InputMismatchException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        Combat combat = new Combat();

        while (true) {
            displayMenu();

            int opc = getUserOption(input);

            switch (opc) {
                case 1:
                    conductCombat(input, combat);
                    break;
                case 2:
                System.out.println("\033[2J\033[3J"); 
                    System.out.println("Saindo do Reino...");
                    System.exit(0);
                default:
                System.out.println("\033[2J\033[3J"); 
                    System.out.println("Opção inválida, tente novamente!");
                    break;
            }
        }
    }

    private static void displayMenu() {
        System.out.println("====== REINO UFMA ======");
        System.out.println("1 - COMBATE");
        System.out.println("2 - SAIR");
        System.out.print("Escolha uma opção: ");
    }

    private static int getUserOption(Scanner input) {
        try {
            return input.nextInt();
        } catch (InputMismatchException entradaErrada) {
            input.nextLine();
            return -1; 
        }
    }

    private static void conductCombat(Scanner input, Combat combat) {
        System.out.println("\033[2J\033[3J"); 
        System.out.println("========= SALA DE COMBATE ==========");
        System.out.println("=====> ESCOLHA OS COMBATENTES <=====");
        System.out.println("=====> 1 - MAGO ");
        System.out.println("=====> 2 - GUERREIRO ");
        System.out.println("=====> 3 - ARQUEIRO ");

        System.out.print("\n=====> PRIMEIRO COMBATENTE: ");
        int firstCharacter = getUserOption(input);

        System.out.print("=====> SEGUNDO COMBATENTE: ");
        int secondCharacter = getUserOption(input);

        if (firstCharacter >= 1 && firstCharacter <= 3 && secondCharacter >= 1 && secondCharacter <= 3 && firstCharacter != secondCharacter) {
            Character winner = combat.combat(firstCharacter, secondCharacter);
            if (winner != null) {
                System.out.println("\033[2J\033[3J"); 
                System.out.println("========= RESULTADO DO COMBATE ==========");
                System.out.printf("O(A) %s FOI VITORIOSO\n", winner.getNome());
                combat.getCombatente(firstCharacter).showDetails();
                combat.getCombatente(secondCharacter).showDetails();
            } else {
                System.out.println("\033[2J\033[3J"); 
                System.out.println("Este embate seria impossível!");
            }
        } else {
            System.out.println("\033[2J\033[3J"); 
            System.out.println("Opção inválida, tente novamente!");
        }
    }
}
