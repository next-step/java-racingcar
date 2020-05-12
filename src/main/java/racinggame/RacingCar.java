package racinggame;

import java.util.Random;

public class RacingCar {

    private static final int MIN_MOVABLE_VALUE = 4;

    private int position;
    private Random random = new Random();

    public static RacingCar newRacingCar() {
        return new RacingCar();
    }

    public void move() {
        if (isMovable(getMovableRandomValue())) {
            this.position++;
        }
    }

    public int currentPosition() {
        return this.position;
    }

    private int getMovableRandomValue() {
        return random.nextInt(10);
    }

    private boolean isMovable(int movableRandomValue) {
        return movableRandomValue >= MIN_MOVABLE_VALUE;
    }
}
