package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차 테스트")
class CarTest {

    @Test
    @DisplayName("자동차 전진 테스트")
    void carMoveTest() {
        Car car = new Car();

        car.move();
        car.move();

        assertThat(car.getPosition()).isEqualTo(2);
    }
}