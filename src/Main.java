import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        boolean validInput = false;
        Player nextPlayer = null;
        Board board = null;
        int games = 0;
        Player player1 = null;
        Player player2 = null;
        Player humanPlayer = null;
        Computer computerPlayer = null;
        boolean validNewGame;

        do {
            do {
                try {
                    if (games == 0) {
                        board = new Board();
                        System.out.println("Välkommen, välj spelläge:\n 1. Spela mot en vän\n 2. Spela mot datorn \n 3. Avsluta");
                        choice = Integer.parseInt(sc.nextLine());
                    } else {
                        validNewGame = false;  // reset  value
                        System.out.println("Vill du/ ni spela igen? (ja/nej)");
                        while (!validNewGame) {
                            String newGame = sc.nextLine();
                            if (newGame.equals("nej")) {
                                choice = 3;
                                validNewGame = true;
                            } else if (newGame.equals("ja")) {
                                board = new Board();
                                validNewGame = true;
                            } else {
                                System.out.println("Ogiltigt svar (endast ja/nej)");
                            }
                        }
                    }
                    if (choice < 1 || choice > 3) {
                        System.out.println("Felaktig inmatning");
                    } else {
                        validInput = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Felaktig inmatning");
                }
            } while (!validInput);

            switch (choice) {
                case 1:
                    if (games == 0) {
                        System.out.println("Skriv in första spelarens namn");
                        player1 = new Player(sc.nextLine(), " X ", true);
                        System.out.println("Skriv in andra spelarens namn");
                        player2 = new Player(sc.nextLine(), " O ", false);
                    }

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
                                System.out.println("\n\n" + nextPlayer.getName() + ": Välj en tom ruta (1-9)");
                                input = Integer.parseInt(sc.nextLine());

                                if (input < 1 || input > 9) {
                                    System.out.println("Felaktig inmatning, välj ett nummer mellan 1-9");
                                } else {
                                    validInput = true; // input valid
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Felaktig inmatning");
                                // sc.nextLine(); // clear invalid input
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
                        nextPlayer.addWin();
                    } else {
                        System.out.println("\nBrädet är fullt, det blev oavgjort \n");
                    }
                    games += 1;
                    System.out.println("Ni har spelat " + games + " omgångar.\n" + player1.getName() + " har vunnit: " + player1.getWins() + "\n" + player2.getName() + " har vunnit: " + player2.getWins());
                    // set correct starting player for next game
                    if (games % 2 == 0 && !player1.isMyTurn()) {
                        player1.changeMyTurn();
                        player2.changeMyTurn();
                    } else if (games % 2 != 0 && !player2.isMyTurn()) {
                        player1.changeMyTurn();
                        player2.changeMyTurn();
                    }

                    break;

                case 2:
                    if (games == 0) {
                        System.out.println("Skriv in ditt namn");
                        humanPlayer = new Player(sc.nextLine(), " X ", true);
                        computerPlayer = new Computer("Computer", " O ", false);  // computer subclass
                    }
                    while (!board.isWinner() && !board.boardFull()) {
                        if (humanPlayer.isMyTurn()) {   // set who is next player
                            nextPlayer = humanPlayer;
                        } else {
                            nextPlayer = computerPlayer;
                        }
                        board.printBoard();
                        if (nextPlayer instanceof Computer) {

                            System.out.println("\n\n" + nextPlayer.getName() + ": Gör ditt drag:");
                            int input;
                            do {
                                input = ((Computer) nextPlayer).randomMove();  // need to make sure it´s a computer object
                            } while (!board.validChoice(input));
                            board.makeMove(input, nextPlayer.getMarker());
                            humanPlayer.changeMyTurn();
                            computerPlayer.changeMyTurn();
                        } else {
                            int input = 0;
                            validInput = false;
                            while (!validInput) {
                                try {
                                    System.out.println("\n\n" + nextPlayer.getName() + ": Välj en tom ruta (1-9)");
                                    input = Integer.parseInt(sc.nextLine());
                                    if (input < 1 || input > 9) {
                                        System.out.println("Felaktig inmatning, välj ett nummer mellan 1-9");
                                    } else {
                                        validInput = true; // input valid
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Felaktig inmatning");
                                }
                            }
                            if (board.validChoice(input)) {
                                board.makeMove(input, nextPlayer.getMarker());
                                humanPlayer.changeMyTurn();
                                computerPlayer.changeMyTurn();
                            } else {
                                System.out.println("Ogiltigt drag, testa igen");
                            }
                        }
                    }
                    board.printBoard();
                    if (board.isWinner()) {
                        System.out.println("\n" + nextPlayer.getName() + " är vinnaren!\n");
                        nextPlayer.addWin();
                    } else {
                        System.out.println("\nBrädet är fullt, det blev oavgjort \n");
                    }
                    games += 1;
                    System.out.println("Du har spelat " + games + " omgångar.\n" + humanPlayer.getName() + " har vunnit: " + humanPlayer.getWins() + "\n" + computerPlayer.getName() + " har vunnit: " + computerPlayer.getWins());
                    // set correct starting player for next game
                    if (games % 2 == 0 && !humanPlayer.isMyTurn()) {
                        humanPlayer.changeMyTurn();
                        computerPlayer.changeMyTurn();
                    } else if (games % 2 != 0 && !computerPlayer.isMyTurn()) {
                        computerPlayer.changeMyTurn();
                        humanPlayer.changeMyTurn();
                    }
                    break;

                case 3:
                    System.out.println("Hejdå!");
                    break;

            }
        }
        while (choice != 3);

    }

}