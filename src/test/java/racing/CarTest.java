package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class CarTest {
    private Car car;

    @BeforeEach
    void setCar() {
        car = new Car("pobi");
    }

    @Test
    @DisplayName("자동차 이름은 5자를 초과할 수 없다")
    void carNameException() {
        assertDoesNotThrow(() -> new Car("pobi"));

        assertThatThrownBy(() -> new Car("pobiss"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("전진 가능")
    void move() {
        car.move(() -> true);

        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName ("전진 불가능")
    void stop() {
        car.move(() -> false);
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("자동차는 여러번 이동할 수 있다")
    void moveForTryCount() {
        int tryCount = 2;
        for (int i = 0; i < tryCount; i++) {
            car.move(() -> true);
        }

        assertThat(car.getDistance()).isEqualTo(2);
    }
}