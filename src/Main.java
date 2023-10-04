import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Välkommen, välj spelläge:\n 1. Spela mot en vän\n 2. Spela mot datorn \n 3. Avsluta");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Skriv in första spelarens namn");
                    String player1 = sc.nextLine();
                    System.out.println("Skriv in andra spelarens namn");
                    String player2 = sc.nextLine();

                case 2:
                    System.out.println("Skriv in ditt namn");
                    String player = sc.nextLine();
                case 3:
                    System.out.println("Hejdå!");
                    break;
            }
        } while (choice != 3);
    }
}