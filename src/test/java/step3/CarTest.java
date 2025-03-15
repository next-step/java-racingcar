package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {

    public static final int START = 0;

    @Test
    @DisplayName("자동차는 전진할 수 있다.")
    void carCanMove() {
        Car car = new Car(START);
        car.move();
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("자동차는 멈출 수 있다.")
    void carCanStop() {
        Car car = new Car(START);
        car.stop();
        assertThat(car.getDistance()).isEqualTo(0);
    }
}
