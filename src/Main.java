import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        Player nextPlayer = null;
        Board board = new Board();

        do {
            System.out.println("Välkommen, välj spelläge:\n 1. Spela mot en vän\n 2. Spela mot datorn \n 3. Avsluta");
            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("Skriv in första spelarens namn");
                    Player player1 = new Player(sc.nextLine(), " X ", true);
                    System.out.println("Skriv in andra spelarens namn");
                    Player player2 = new Player(sc.nextLine(), " O ", false);

                    // repeat as long as no winner and board is not full
                    while (!board.isWinner() && !board.boardFull()) {
                        board.printBoard();
                        if (player1.isMyTurn()) {   // set who is next player
                            nextPlayer = player1;
                        } else {
                            nextPlayer = player2;
                        }
                        System.out.println("\n" + nextPlayer.getName() + ": Välj en tom ruta (1-9)");
                        int input = sc.nextInt();
                        sc.nextLine();
                        // makes move
                        if (board.validChoice(input)) {
                            board.makeMove(input, nextPlayer.getMarker());
                            player1.changeMyTurn();
                            player2.changeMyTurn();
                        } else {
                            System.out.println("Ogiltigt drag, testa igen");
                        }
                    }
                    // when while loop ended, the game ends
                    board.printBoard();
                    if (board.isWinner()) {
                        System.out.println("\n" + nextPlayer.getName() + " är vinnaren!\n");
                    } else {
                        System.out.println("\nBrädet är fullt, det blev oavgjort \n");
                    }
                    break;

                case 2:
                    System.out.println("Skriv in ditt namn");
                    Player humanPlayer = new Player(sc.nextLine(), " X ", true);
                    Player computerPlayer = new Player("Computer", " O ", false);
                    // check if nextplayer is a computor (class)
                    // run randomMove
                    // check if valid withput sout
                    // change player when valid otherwise repeat


                    break;

                case 3:
                    System.out.println("Hejdå!");
                    break;
            }
        } while (choice != 3);
        // Count how many wins
    }
}