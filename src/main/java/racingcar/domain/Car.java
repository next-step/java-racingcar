package racingcar.domain;

import java.util.Random;
import racingcar.common.utils.TextLimitSizeValidator;

public class Car {

        private static final int RANDOM_BOUND = 10;
        private static final int START_INIT_VALUE = 1;
        private static final int LOWER_LIMIT = 4;
        private static final int NAME_LENGTH_LIMIT = 5;
        private static final Random random = new Random();
        private final String name;
        private int currentPosition;

        public Car(String name) {
                this.name = name;
                currentPosition = START_INIT_VALUE;
                errorIfNameLengthLimitOver();
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

        private void errorIfNameLengthLimitOver(){
                if (TextLimitSizeValidator.isOverLimitSize(this.name, NAME_LENGTH_LIMIT)){
                        throw new IllegalArgumentException("자동차 이름은" + NAME_LENGTH_LIMIT + "자 이상만 입력 가능합니다.");
                }
        }

        private boolean isAbleToMove() {
                return random.nextInt(RANDOM_BOUND) >= LOWER_LIMIT;
        }

        public String getName(){
                return name;
        }

        public int getCurrentPosition() {
                return currentPosition;
        }

}
