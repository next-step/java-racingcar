package racingCar;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @DisplayName("자동차를 생성하면 초기 위치는 0 이다.")
    @Test
    void Car_초기위치() {
        Car car = new Car();
        assertThat(0).isEqualTo(car.getCurrentPosition());
    }
}
