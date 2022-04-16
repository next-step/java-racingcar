package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.test.util.ReflectionTestUtils;
import util.MoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;

    @BeforeEach
    void init() {
        car = new Car();
        ReflectionTestUtils.setField(car, "position", 5);
    }

    @DisplayName("자동차 이동 테스트")
    @ParameterizedTest
    @CsvSource(value = {"true:1", "false:0"}, delimiter = ':')
    void carMoveTest(boolean movable, int moveDistance) {
        int beforePosition = car.getPosition().getPosition();

        car.move(TestMoveStrategy.getInstance(movable));

        assertThat(car.getPosition().getPosition()).isEqualTo(beforePosition + moveDistance);
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
