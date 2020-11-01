package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("Car 클래스의 테스트")
class CarTest {

    @Test
    @DisplayName("movable 인 경우만 전진해야 한다.")
    void move() {
        MoveStrategy movableStrategy = new MoveStrategy() {
            @Override
            public boolean checkMovable() {
                return true;
            }
        };
        Car movableCar = new Car(movableStrategy);

        MoveStrategy stopStrategy = new MoveStrategy() {
            @Override
            public boolean checkMovable() {
                return false;
            }
        };
        Car stoppedCar = new Car(stopStrategy);


        movableCar.move();
        stoppedCar.move();

        int movedPosition = 2;
        int stoppedPosition = 1;
        assertThat(movableCar.getPosition())
                .isEqualTo(movedPosition);
        assertThat(stoppedCar.getPosition())
                .isEqualTo(stoppedPosition);
    }
}
