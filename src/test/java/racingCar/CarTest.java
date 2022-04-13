package racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @DisplayName("랜덤값이 4 미만인 경우 전진할 수 없다")
    @Test
    void RandomNumberIsLessThanFour() {
        assertThat(car.canMoveForward(3)).isFalse();
    }

    @DisplayName("랜덤값이 4 이상인 경우 전진한다")
    @Test
    void RandomNumberIsMoreThanFour() {
        assertThat(car.canMoveForward(4)).isTrue();
    }
}
