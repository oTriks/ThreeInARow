import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        Board board = new Board();


        do {
            System.out.println("Välkommen, välj spelläge:\n 1. Spela mot en vän\n 2. Spela mot datorn \n 3. Avsluta");
            choice = sc.nextInt();
    sc.nextLine();
                switch (choice) {
                case 1:
                    System.out.println("Skriv in första spelarens namn");
                    Player player1 = new Player(sc.nextLine(), "X", true);
                    System.out.println("Skriv in andra spelarens namn");
                    String player2 = sc.nextLine();

                    String nextPlayer = player1;

                    while(!board.gameFinished()) {
                        board.printBoard();

                        System.out.println("\n" + nextPlayer + ": Välj en tom ruta (1-9)");
                        int input = sc.nextInt();
                        sc.nextLine();
                        if(board.validChoice(input)) {
                            if (nextPlayer.equals(player1)) {
                                board.makeMove(input, "X");
                            } else {
                                board.makeMove(input, "O");
                            }
                            if(nextPlayer.equals(player1)){
                                nextPlayer = player2;
                            } else {
                                nextPlayer = player1;
                            }
                        }else{
                            System.out.println("Ogiltigt drag, testa igen");
                        }


                    }
                    board.printBoard();
                    System.out.println("Spelet är slut");
                    // someone won?  (results)
                    // check if someone won or if game is full
                    break;

                case 2:
                    System.out.println("Skriv in ditt namn");
                    String player = sc.nextLine();

                    break;

                case 3:
                    System.out.println("Hejdå!");
                    break;
            }
        } while (choice != 3);
    }
}