package step3.domain;

import java.util.Random;

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
