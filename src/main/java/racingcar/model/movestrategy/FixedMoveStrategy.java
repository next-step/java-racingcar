package racingcar.model.movestrategy;

public class FixedMoveStrategy implements MoveStrategy {

        private static final int LOWER_LIMIT = 4;
        private int value;

        public FixedMoveStrategy(int value) {
                this.value = value;
        }

        @Override
        public boolean isAbleToMove() {
                return this.value >= LOWER_LIMIT;
        }
}
