import java.util.ArrayList;

public class Board {

    private ArrayList<String> board = new ArrayList<>(9);


    public Board() {
for(int i = 0; i < 9; i++) {
    board.add("   ");
}
    }

    public void printBoard() {
    for(int i = 0; i < this.board.size(); i++) {

        System.out.print(this.board.get(i));
        if (i != 2 && i != 5 && i != 8){

            System.out.print("|");
        }else {

            System.out.println("\n---+---+---");
        }
    }


    }
}
