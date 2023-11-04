package car_racing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CarTest {

    @Test
    @DisplayName("생성/현재위치와 남은이동횟수로 생성/생성된다.")
    void createCar() {
        Car car = new Car(0, 10);
        assertThat(car).isInstanceOf(Car.class);
    }

    @Test
    @DisplayName("이동/자동차가 랜덤값이 4이상일경우 이동/현재위치가 랜덤값만큼 증가, 이동횟수 차감")
    void moveCar() {
        // given
        Car car = new Car(0, 1);

        // when
        car.move();

        // then
        Integer currentPosition = car.getCurrentPosition();
        assertTrue(currentPosition.equals(0) || (currentPosition >= 4 && currentPosition <= 9));
    }
}
