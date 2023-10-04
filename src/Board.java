import java.util.ArrayList;

public class Board {

    ArrayList<String> board = new ArrayList<>(9);


    public Board() {

    }

    public void printBoard() {
    for(int i = 0; i < board.size(); i++) {
        System.out.print(board.get(i));
    }


    }
}
