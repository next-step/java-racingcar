package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    RacingCar rc = new RacingCar();
    Car car = new Car();
    int carCount = 3;

    @Test
    void 차_이름_예외처리() {
        assertThatThrownBy(() -> car.checkName("123456"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void addCount() {
        car.addGoCount();
        Assertions.assertThat(car.getGoCount()).isEqualTo(1);
    }

}
