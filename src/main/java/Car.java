import java.util.Random;

public class Car {
    private static final Random random = new Random();
    private static final int moveThreshold = 4;
    private int position;
    
    public int move() {
        if (canMove()) position++;
        return position;
    }

    private boolean canMove() {
        return random.nextInt(10) >= moveThreshold;
    }

}
