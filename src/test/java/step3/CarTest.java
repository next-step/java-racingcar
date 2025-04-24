package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @DisplayName("자동차는 조건(랜덤값이 4이상)을 만족하면 한 칸 전진할 수 있다")
    @Test
    void moveCar() {
        Car car = new Car();

        assertThat(car.move(new MoveNumberGenerator()))
                .isEqualTo(new Position().moveForward());
    }

    @DisplayName("자동차는 조건(랜덤값이 4이상)을 만족하지 못하면 멈춘다")
    @Test
    void stopCar() {
        Car car = new Car();

        assertThat(car.move(new StopNumberGenerator())).isEqualTo(new Position());
    }
}
