import java.util.Random;

public class Computer extends Player {
    Random random = new Random();

    public Computer(String name, String marker, boolean myTurn) {
        super(name, marker, myTurn);
    }

    public int randomMove() {
        return random.nextInt(9);
    }

}
