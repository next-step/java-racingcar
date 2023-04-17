package racingcar;

import org.assertj.core.api.Assertions;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.CarRace;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RacingCarTest {

    @DisplayName("자동차 초기 위치가 0인지 Test")
    @Test
    void carFirstLocation() {
        Car car = new Car();
        int location = car.carLocation();
        Assertions.assertThat(location).isZero();
    }


    @DisplayName("random 값이 4 이상일 경우 true 반환 Test")
    @Test
    void carMoveWithCondition() {
        CarRace carRace = new CarRace();
        assertTrue(carRace.isCanMove(4));
    }
}
