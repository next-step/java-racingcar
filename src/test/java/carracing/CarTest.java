package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("차가 전진하면 이동 상태가 1 더해진다.")
    @Test
    void test() {
        Car car = new Car();

        car.move();

        assertThat(car.getMoveStatus()).isEqualTo(1);
    }
}
