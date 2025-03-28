package step4;

import org.junit.jupiter.api.Test;
import step4.domain.Car;
import step4.domain.RandomMoveStrategy;

import java.util.Random;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoveStrategyTest {
    @Test
    void shouldReturnTrue_whenRandomNumberIsGreaterThanOrEqualToThreshold() {
        Random random = new Random() {
            @Override
            public int nextInt(int bound) {
                return 4;
            }
        };

        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy(random);

        assertThat(randomMoveStrategy.isMovable()).isTrue();
    }

    @Test
    void shouldReturnFalse_whenRandomNumberIsLessThanThreshold() {
        Random random = new Random() {
            @Override
            public int nextInt(int bound) {
                return 3;
            }
        };

        RandomMoveStrategy randomMoveStrategy = new RandomMoveStrategy(random);

        assertThat(randomMoveStrategy.isMovable()).isFalse();
    }


    @Test
    void shouldMoveForward_whenStrategyAlwaysAllowsMovement() {
        TestMoveStrategy moveForwardUnconditionallyStrategy =  new TestMoveStrategy(true);
        Car car = new Car("TestCar");

        int initialPosition = car.getPosition();
        car.move(moveForwardUnconditionallyStrategy);

        assertEquals(initialPosition + 1, car.getPosition(), "MoveStrategy가 true를 반환하면 position은 1 증가해야 합니다.");
    }

    @Test
    void shouldNotMove_whenStrategyPreventsMovement() {
        TestMoveStrategy noMoveStrategy =  new TestMoveStrategy(false);
        Car car = new Car("TestCar");

        int initialPosition = car.getPosition();
        car.move(noMoveStrategy);

        assertEquals(initialPosition, car.getPosition(), "MoveStrategy가 false를 반환하면 position은 변하지 않아야 합니다.");
    }
}
