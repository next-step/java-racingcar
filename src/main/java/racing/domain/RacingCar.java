package racing.domain;

import java.util.Random;

public class RacingCar {
    private final int MOVE_CONIDTION = 4;

    private String name = null;
    private int position = 0;

    public RacingCar(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCurrentPosition() {
        return position;
    }

    public void move(int drivingForce) {
        if (canMove(drivingForce)) {
            moveOneSpace();
        }
    }

    private void moveOneSpace() {
        position++;
    }

    private boolean canMove(int drivingForce) {
        return drivingForce >= MOVE_CONIDTION;
    }

    public static class RandomMoveGenerator {
        private Random random = null;

        public static final int MAX_MOVE_SIZE = 10;

        public RandomMoveGenerator() {
            this.random = new Random();
        }

        public int generate() {
            return random.nextInt(MAX_MOVE_SIZE);
        }
    }
}
