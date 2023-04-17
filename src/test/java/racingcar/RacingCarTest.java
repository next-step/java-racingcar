package racingcar;

import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

public class RacingCarTest {

    @DisplayName("자동차 초기 위치가 0인지 Test")
    @Test
    void carFirstLocation() {
        Car car = new Car();
        int location = car.carLocation();
        Assertions.assertThat(location).isZero();
    }

    @DisplayName("random 값이 4이상일 경우 자동차 전진 Test")
    @Test
    void carMoveByMoveDistance() {
        Car car = new Car();
        int firstLocation = car.carLocation();
        car.moveToFront(4);

        int afterLocation = car.carLocation();
        Assertions.assertThat(afterLocation).isEqualTo(firstLocation+1);
    }

    @DisplayName("random 값이 4미만일 경우 자동차 전진 X Test")
    @Test
    void carDontMoveByMoveDistance() {
        Car car = new Car();
        int firstLocation = car.carLocation();
        car.moveToFront(3);

        int afterLocation = car.carLocation();
        Assertions.assertThat(afterLocation).isEqualTo(firstLocation);
    }
}
