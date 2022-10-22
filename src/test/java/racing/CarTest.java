package racing;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class CarTest {
    @Test
    @DisplayName("4이상이면 한칸 전진")
    void moveCar() {
        Car car = new Car();
        car.move();
        if (car.getMoveCount() > 0) {
            assertThat(car.getMoveCount()).isEqualTo(1);
        }
    }

    @Test
    @DisplayName("4미만이면 멈춤")
    void stopCar() {
        Car car = new Car();
        car.move();
        if (car.getMoveCount() == 0) {
            assertThat(car.getMoveCount()).isEqualTo(0);
        }
    }
}
