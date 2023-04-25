package race;

import race.domain.MoveStrategy;

public class TestHelper {
    public static class AlwaysMoveStrategy implements MoveStrategy {
        @Override
        public boolean canMove() {
            return true;
        }
    }

    public static class NeverMoveStrategy implements MoveStrategy {
        @Override
        public boolean canMove() {
            return false;
        }
    }
}
