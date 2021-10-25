package racingcar.domains;

import org.junit.jupiter.api.Test;
import racingcar.strategies.MoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CarTest {

    @Test
    void 전진() {
        Car car = new Car("blue");

        MoveStrategy moveStrategy = new MoveStrategy() {
            @Override
            public boolean isMovable() {
                return true;
            }
        };

        car.move(moveStrategy);
        car.move(moveStrategy);

        assertThat(car).isEqualTo(new Car("blue", 2));
    }

    @Test
    void 멈춤() {
        Car car = new Car("blue");

        MoveStrategy moveStrategy = new MoveStrategy() {
            @Override
            public boolean isMovable() {
                return false;
            }
        };

        car.move(moveStrategy);

        assertThat(car).isEqualTo(new Car("blue", 0));
    }

    @Test
    void 차_위치비교() {
        Car young = new Car("young", 10);
        Car old = new Car("old", 2);

        boolean result = young.isAhead(old);

        assertTrue(result);
    }

    @Test
    void 차_위치_동등비교() {
        Car young = new Car("young", 6);
        Car old = new Car("old", 6);

        boolean result = young.equalsPosition(old);

        assertTrue(result);
    }
}