package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.model.move.MoveStrategy;
import racing.model.move.RandomMoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("자동차는 숫자 0에서 9 사이 random 값이 4이상일 경우(RandomMoveStrategy) 전진")
    @Test
    void moveTest() {
        Car car = new Car();
        MoveStrategy moveStrategy = new RandomMoveStrategy();
        car.move(new RandomMoveStrategy() {
            @Override
            public boolean move() {
                return true;
            }
        });

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("자동차는 숫자 0에서 9 사이 random 값이 4미만일 경우 정지")
    @Test
    void stopTest() {
        Car car = new Car();
        car.move(new RandomMoveStrategy() {
            @Override
            public boolean move() {
                return false;
            }
        });

        assertThat(car.getPosition()).isEqualTo(0);
    }
}
