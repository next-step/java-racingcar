package racingcar.model.movestrategy;

import java.util.Random;

public class RandomMoveStrategy implements MoveStrategy {

        private static final Random random = new Random();
        private static final int RANDOM_BOUND = 10;
        private static final int LOWER_LIMIT = 4;

        public RandomMoveStrategy() {
        }

        @Override
        public boolean isAbleToMove() {
                return random.nextInt(RANDOM_BOUND) >= LOWER_LIMIT;
        }
}
