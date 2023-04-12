package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.RandomNumberGenerator;

@DisplayName("자동차의 전진과 멈춤을 역할을 담당하는 Car 객체 테스트")
public class CarTest {

    @DisplayName("랜덤값을 구한 후 전진 또는 멈출수 있다")
    @Test
    void carTest() {
        Car car = new Car();
        car.move(new RandomNumberGenerator());
        Assertions.assertThat(car.getPoint()).isBetween(0, 1);
    }
}
