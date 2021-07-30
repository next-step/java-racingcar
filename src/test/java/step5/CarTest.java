package step5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @Test
    @DisplayName("Car이 진행하거나 진행하지 않는 케이스가 나오는지 테스트")
    void goOrStopTest() {
        Car car = new Car("MovingCar");
        car.goOrStop(() -> true);

        assertThat(car.getCarLocation().equals(new CarLocation(1))).isTrue();

        Car car2 = new Car("StoppedCar");
        car2.goOrStop(() -> false);

        assertThat(car2.getCarLocation().equals(new CarLocation(0))).isTrue();
    }
}
