package step3.domain;

import java.util.Random;

public enum DecideMode {
    RANDOM_MODE {
        private final Random random = new Random();
        private final int DECIDE_NUM = 4;
        @Override
        public boolean checkMovable() {
            return random.nextInt(10) > DECIDE_NUM;
        }
    },
    TRUE_RETURN_MODE {
        @Override
        public boolean checkMovable() {
            return true;
        }
    },
    FALSE_RETURN_MODE {
        @Override
        public boolean checkMovable() {
            return false;
        }
    };

    public abstract boolean checkMovable();
}
