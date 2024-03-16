package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    Car car = new Car();

    @Test
    @DisplayName("(1)자동차의 위치를 전달")
    public void position() {

        Assertions.assertThat(car.position()).isEqualTo(0);
    }

    @Test
    @DisplayName("(2)자동차의 위치를 업데이트")
    public void updatePosition() {
        car.updatePosition();
        Assertions.assertThat(car.position()).isEqualTo(0);
    }
}
