package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.test.util.ReflectionTestUtils;
import util.MoveStrategy;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarsTest {
    @DisplayName("자동차 대수를 입력했을 때 Cars가 정상적으로 생성되는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 5, 10, 20, 100})
    void constructCarsTest(int size) {
        Cars cars = new Cars(size);
        assertThat((List<Car>) ReflectionTestUtils.getField(cars, "cars")).hasSize(size);
    }

    @DisplayName("movable 전략에 따라 자동차가 움직이는지 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"true", "false"})
    void constructCarsTest(boolean movable) {
        Cars cars = new Cars(50);
        Positions positions = cars.moveCars(TestMoveStrategy.getInstance(movable));
        positions.getPositions()
                .forEach(position -> assertThat(position).isEqualTo(movable ? 1 : 0));
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