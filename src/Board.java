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


    // check if the board is full (not containing "   ")
    public boolean boardFull() {
        for(int i = 0; i < this.board.size(); i++) {
            if (this.board.get(i).equals("   ")) {
                return false;
            }
        }
        return true;     // never found an empty position on board
    }


    // check if chosen position is "empty"
    public boolean validChoice(int choice) {
        if(this.board.get(choice - 1).equals("   ")) {
            return true;
        } else {
            return false;
        }
    }

    // runs after "validChoice()"
    public void makeMove(int choice, String marker) {
        this.board.set(choice - 1, marker);
    }


    // all possible winning combinations
    public boolean isWinner() {
        if (this.board.get(0).equals(this.board.get(1)) && this.board.get(1).equals(this.board.get(2)) && !this.board.get(0).equals("   ")) {
            return true;
        } else if (this.board.get(3).equals(this.board.get(4)) && this.board.get(4).equals(this.board.get(5)) && !this.board.get(3).equals("   ")) {
            return true;
        } else if (this.board.get(6).equals(this.board.get(7)) && this.board.get(7).equals(this.board.get(8)) && !this.board.get(6).equals("   ")) {
            return true;
        } else if (this.board.get(0).equals(this.board.get(3)) && this.board.get(3).equals(this.board.get(6)) && !this.board.get(0).equals("   ")) {
            return true;
        } else if (this.board.get(1).equals(this.board.get(4)) && this.board.get(4).equals(this.board.get(7)) && !this.board.get(1).equals("   ")) {
            return true;
        } else if (this.board.get(2).equals(this.board.get(5)) && this.board.get(5).equals(this.board.get(8)) && !this.board.get(2).equals("   ")) {
            return true;
        } else if (this.board.get(0).equals(this.board.get(4)) && this.board.get(4).equals(this.board.get(8)) && !this.board.get(0).equals("   ")) {
            return true;
        } else if (this.board.get(2).equals(this.board.get(4)) && this.board.get(4).equals(this.board.get(6)) && !this.board.get(2).equals("   ")) {
            return true;
        } else {
            return false;
        }
    }
}
