import java.util.ArrayList;

public class Board {

    private ArrayList<String> board = new ArrayList<>(9);


    // fills the list with "empty" strings for setup of game
    public Board() {
        for (int i = 0; i < 9; i++) {
            board.add("   ");
        }
    }


    // this metod prints the current gameboard
    public void printBoard() {
        for (int i = 0; i < this.board.size(); i++) {   //   looping for every position in the list

            System.out.print(this.board.get(i));
            if (i != 2 && i != 5 && i != 8) {  //  no vertical divider when there is a new row on board

                System.out.print("|");
            } else if (i != 8) {  // no divider after the last position

                System.out.println("\n---+---+---");
            }
        }

    }

    public boolean gameFinished() {
        if(threeInARow() || boardFull()) {
            return true;
        } else {
            return false;
        }
    }


    public boolean boardFull() {
        for (int i = 0; i < this.board.size(); i++) {
            if (this.board.get(i).equals("   ")) {
                return false;
            }
        }
        return true;     // never found an empty position on board
    }

    public boolean threeInARow() {
        return false;
    }

    public boolean validChoice(int choice) {
        if (this.board.get(choice - 1).equals("   ")) {
            return true;
        } else {
            return false;
        }
    }

    public void makeMove(int choice, String marker) {
        this.board.set(choice - 1, marker);
    }

}
