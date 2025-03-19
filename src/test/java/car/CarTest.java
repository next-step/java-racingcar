package car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.FixedNumberGenerator;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @Test
    @DisplayName("숫자가 4 이상일 때 자동차가 전진한다.")
    void 자동차_전진() {
        Car car = new Car("pobi");
        car.move(new FixedNumberGenerator(4));
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자가 4 미만일 때 자동차가 정지한다.")
    void 자동차_정지() {
        Car car = new Car("pobi");
        car.move(new FixedNumberGenerator(1));
        assertThat(car.getPosition()).isEqualTo(0);
    }



}
