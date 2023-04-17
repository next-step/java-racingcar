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
}
