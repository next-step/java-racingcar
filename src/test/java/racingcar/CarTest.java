package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.strategy.MovingStrategy;

class CarTest {

    Car car;
    MovingStrategy testMovingStrategy;

    @BeforeEach
    void setUp() {
        car = new Car();
    }
    @Test
    public void position_증가() {
        testMovingStrategy = new TestSuccessMoveStrategy();
        car.move(testMovingStrategy);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    public void 포지션변화_실패() {
        testMovingStrategy = new TestFailMoveStrategy();
        car.move(testMovingStrategy);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    public static class TestSuccessMoveStrategy implements MovingStrategy {

        @Override
        public boolean isMove() {
            return true;
        }
    }

    public static class TestFailMoveStrategy implements MovingStrategy {

        @Override
        public boolean isMove() {
            return false;
        }
    }
}