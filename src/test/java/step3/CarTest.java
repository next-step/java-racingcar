package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {


    @Test
    void 자동차는_1칸_움직이거나_움직이지_않는다() {
        Car car = new Car();

        car.move(() -> true);
        Assertions.assertThat(car.getPosition()).isEqualTo(1);

        car.move(() -> false);
        Assertions.assertThat(car.getPosition()).isEqualTo(1);
    }

}