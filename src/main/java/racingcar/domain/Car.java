package racingcar.domain;

import java.util.Random;

public class Car {

        private static final int RANDOM_BOUND = 10;
        private static final int START_INIT_VALUE = 1;
        private static final int LOWER_LIMIT = 4;
        private static final Random random = new Random();
        private int currentPosition;

        public Car() {
                currentPosition = START_INIT_VALUE;
        }

        public void moveForward() {
                ++currentPosition;
        }

        public boolean movedForwardIfCan() {
                boolean ableToMove = isAbleToMove();
                if (ableToMove) {
                        this.moveForward();
                }
                return ableToMove;
        }

        private boolean isAbleToMove() {
                return random.nextInt(RANDOM_BOUND) >= LOWER_LIMIT;
        }

        public int getCurrentPosition() {
                return currentPosition;
        }

}
