package domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import util.MoveStrategy;

class CarsTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 100})
    void constructCarsTest(int size) {
        Cars cars = new Cars(size);
        Positions positions = cars.moveCars(TestMoveStrategy.testMoveStrategy);

    }

    static class TestMoveStrategy implements MoveStrategy {
        private static final TestMoveStrategy testMoveStrategy = new TestMoveStrategy();
        private static boolean moveState = false;

        private TestMoveStrategy() {
        }

        public static TestMoveStrategy getInstance(boolean moveState) {
            TestMoveStrategy.moveState = moveState;
            return testMoveStrategy;
        }

        @Override
        public boolean isMovable() {
            return moveState;
        }
    }
}