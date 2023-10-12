import java.util.Random;

public class Computer extends Player {
    Random random = new Random(); // random number generator

    public Computer(String name, String marker, boolean myTurn) {
        super(name, marker, myTurn);
    }



    public int randomMove() {
        return random.nextInt(8) + 1;
    }

}
