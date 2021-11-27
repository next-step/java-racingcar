package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.RandomValue;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("자동차 이동 테스트")
    void carMoveLocationTest() {
        int firstLocation = 2;
        Car car = new Car("이름1", firstLocation);
        RandomValue randomValue = new RandomValue(5);
        car.move(randomValue);
        assertThat(car.getLocation()).isEqualTo(firstLocation + 1);
    }
}
