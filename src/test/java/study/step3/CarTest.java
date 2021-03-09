package study.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("차의 출발점은 0")
    @Test
    void getLocation() {
        Car car = Car.of();
        assertThat(car.getLocation()).isEqualTo(0);
    }

    @DisplayName("차량 이동")
    @Test
    void move() {
        Car car = Car.of();
        car.move().move().move().getLocation();

        assertThat(car.getLocationString().length()).isEqualTo(car.getLocation());
    }

}
