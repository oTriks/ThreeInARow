import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        boolean validInput = false;
        Player nextPlayer = null;
        Board board = new Board();


        do {
            try {
                System.out.println("Välkommen, välj spelläge:\n 1. Spela mot en vän\n 2. Spela mot datorn \n 3. Avsluta");
                choice = sc.nextInt();
                sc.nextLine();
                validInput = true; // input now valid
            } catch (InputMismatchException e) {
                System.out.println("Felaktig inmatning");
                sc.nextLine(); // clear invalid input
            }
        } while (!validInput);

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
                    int input = 0;
                    validInput = false;
                    while (!validInput) {
                        try {
                            System.out.println("\n" + nextPlayer.getName() + ": Välj en tom ruta (1-9)");
                            input = sc.nextInt();
                            sc.nextLine();
                            if (input < 1 || input > 9) {
                                System.out.println("Felaktig inmatning, välj ett nummer mellan 1-9");
                                validInput = false;
                            } else {
                                validInput = true; // input valid
                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Felaktig inmatning");
                            sc.nextLine(); // clear invalid input
                        }
                    }
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
                Computer computerPlayer = new Computer("Computer", " O ", false);  // computer subclass
                while (!board.isWinner() && !board.boardFull()) {
                    if (humanPlayer.isMyTurn()) {   // set who is next player
                        nextPlayer = humanPlayer;
                    } else {
                        nextPlayer = computerPlayer;
                    }
                    board.printBoard();
                    if (nextPlayer instanceof Computer) {
                        System.out.println();  // add space
                        System.out.println();  // add space
                        int input;
                        do {
                            input = ((Computer) nextPlayer).randomMove();
                        } while (!board.validChoice(input));
                        board.makeMove(input, nextPlayer.getMarker());
                        humanPlayer.changeMyTurn();
                        computerPlayer.changeMyTurn();
                    } else {
                        int input = 0;
                        validInput = false;
                        while (!validInput) {
                            try {
                        System.out.println("\n" + nextPlayer.getName() + ": Välj en tom ruta (1-9)");
                                input = sc.nextInt();
                                sc.nextLine();
                                if (input < 1 || input > 9) {
                                    System.out.println("Felaktig inmatning, välj ett nummer mellan 1-9");
                                    validInput = false;
                                } else {
                                    validInput = true; // input valid
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Felaktig inmatning");
                                sc.nextLine(); // clear invalid input
                            }
                        }
                        //
                        input = sc.nextInt();
                        sc.nextLine();
                        if (board.validChoice(input)) {
                            board.makeMove(input, nextPlayer.getMarker());
                            humanPlayer.changeMyTurn();
                            computerPlayer.changeMyTurn();
                        } else {
                            System.out.println("Ogiltigt drag, testa igen");
                        }
                    }
                }
                break;

            case 3:
                System.out.println("Hejdå!");
                break;

    } while(choice !=3);
    // Count how many wins

    }
}