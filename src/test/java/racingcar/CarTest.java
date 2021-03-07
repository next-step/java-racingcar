package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("자동차를 생성한다")
    @Test
    void createCarTest() {
        Car car = new Car();
        assertThat(car.showStatus()).isEqualTo("");
    }

    @DisplayName("자동차는 이동하거나 이동하지 않는다")
    @Test
    void moveCarTest() {
        Car car = new Car();
        car.move();
        assertThat(car.showStatus()).isIn("", "-");
    }
}
