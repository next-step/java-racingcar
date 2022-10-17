package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CarTest {

    private Car car;

    @BeforeEach
    void setCar() {
        car = new Car("pobi");
    }

    @Test
    @DisplayName("랜덤값이 4이상인 경우 전진(1)")
    void move() {
        car.move(4);
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName ("랜덤값이 3이하인 경우 멈춤(0)")
    void stop() {
        car.move(3);
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차는 여러번 이동할 수 있다")
    void moveForTryCount() {
        int tryCount = 2;
        for (int i = 0; i < tryCount; i++) {
            car.move(4);
        }

        assertThat(car.getDistance()).isEqualTo(2);
    }
}