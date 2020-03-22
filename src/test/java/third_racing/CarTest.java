package third_racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;

    @Test
    @DisplayName("차이동테스트")
    void moveTest() {
        car = new Car();
        car.move();
        car.move();

        assertThat(car.getCarPosition()).isEqualTo(3);
    }

    @Test
    @DisplayName("차번호셋팅테스트")
    void carPartInTest() {
        car = new Car();
        car.carPartIn(1);
        assertThat(car.getCarNo()).isEqualTo(1);
    }
}
