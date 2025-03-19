import java.util.Random;

public class Car {
    private static final Random random = new Random();
    private static final int moveThreshold = 4;
    private int position;
    
    public void move() {
        if (canMove()) position++;
    }

    private boolean canMove() {
        return random.nextInt(10) >= moveThreshold;
    }

    public int getPosition() {
        return position;
    }
}
