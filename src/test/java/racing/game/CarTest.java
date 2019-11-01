package racing.game;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.Strategy.MoveStrategy;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("move에서 t/f 에 따라 포지션 이동하는지")
    @Test
    void moveAndGetCarPositionTest() {
        Car car = new Car("testCar");

        car.move(new MoveStrategy() {
            @Override
            public boolean isMove() {
                return false;
            }
        });
        assertThat(car.getPosition(0)).isEqualTo(0);

        car.move(() -> {
            return true;
        });
        assertThat(car.getPosition(1)).isEqualTo(1);

    }


}