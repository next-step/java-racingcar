package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("[성공] 자동차가 4 이상의 값을 전달받는 경우 전진한다.")
    void 자동차_전진() {
        Car car = new Car();
        int distance = car.move(4);
        assertThat(distance).isEqualTo(1);
    }

    @Test
    @DisplayName("[성공] 자동차가 4 미만의 값을 전달받는 경우 전진하지 않는다.")
    void 자동차_정지() {
        Car car = new Car();
        int distance = car.move(3);
        assertThat(distance).isEqualTo(0);
    }

}
