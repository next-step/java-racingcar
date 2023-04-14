import java.util.Random;

public class Car {
    public static final int MOVEABLE_POWER = 4;
    private int moveCount = 0;

    int getRandomNumber() {
        Random random = new Random();

        return random.nextInt(10);
    }

    public void moveForwardOrStop(int inputPower) {
        if (inputPower >= MOVEABLE_POWER) {
            moveCount++;
        }
    }

    public int getMoveCount() {
        return moveCount;
    }
}
