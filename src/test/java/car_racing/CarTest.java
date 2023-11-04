package car_racing;

import car_racing.move_strategy.RandomMoveStopStrategy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarTest {

    @Test
    @DisplayName("생성/자동차의 이동전략 기반 생성/생성된다.")
    void createCar() {
        Car car = new Car(new RandomMoveStopStrategy());
        assertThat(car).isInstanceOf(Car.class);
    }

    @Test
    @DisplayName("이동/자동차가 랜덤값이 4이상일경우 이동/현재위치가 랜덤값만큼 증가, 이동횟수 차감")
    void moveCar() {
        // given
        Car car = new Car(new RandomMoveStopStrategy());

        // when
        car.move();

        // then
        Integer currentPosition = car.getPosition();
        assertTrue(currentPosition.equals(1) || (currentPosition >= 5 && currentPosition <= 10));
    }
}
