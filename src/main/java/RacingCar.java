import java.util.Random;

public class RacingCar {
    private final Random random = new Random();

    public int createRandom() {
        return random.nextInt(10);
    }

    public boolean isGoingForward(int value) {
        return value >= 4;
    }
}
