package racingcar.model.movestrategy;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

        private static final Random random = new Random();
        private static final int RANDOM_BOUND = 10;
        private static final int LOWER_LIMIT = 4;
        private int value;

        public RandomMoveStrategy() {
        }

        @Override
        public boolean isAbleToMove() {
                this.value = random.nextInt(RANDOM_BOUND);
                return this.value >= LOWER_LIMIT;
        }
}
