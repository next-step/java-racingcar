package step3;

import java.util.Random;

public class Car {
    private int distance = 0;
    private String name;

    public Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    public void move(DecideMode mode) {
        moveSelectMode(mode);
    }

    public void move() {
        moveSelectMode(DecideMode.RANDOM_MODE);
    }

    private boolean decideForward(DecideMode mode) {
        return mode.getCanMove();
    }

    public int getDistance() {
        return distance;
    }

    public String getName() {
        return name;
    }

    private void moveSelectMode(DecideMode mode) {
        if(decideForward(mode)) {
            distance++;
        }
    }

    public enum DecideMode {
        RANDOM_MODE {
            @Override
            public boolean getCanMove() {
                return random.nextInt(10) > DECIDE_NUM;
            }
        },
        TRUE_RETURN_MODE {
            @Override
            public boolean getCanMove() {
                return true;
            }
        },
        FALSE_RETURN_MODE {
            @Override
            public boolean getCanMove() {
                return false;
            }
        };

        public abstract boolean getCanMove();
        private static final Random random = new Random();
        private static final int DECIDE_NUM = 4;
        }
}
