package racingCar.domains;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingCar.utils.FixedNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @DisplayName("조건(랜덤값)이 4 미만인 경우 전진할 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void numberIsLessThanFour(int input) {
        Car car = new Car("test", new FixedNumberGenerator(input));
        car.move();

        assertThat(car.getPosition()).isEqualTo(0);
    }

    @DisplayName("조건(랜덤값)이 4 이상일 경우 전진한다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8,9})
    void numberIsMoreThanFour(int input) {
        Car car = new Car("test", new FixedNumberGenerator(input));
        car.move();

        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void nullStrategy() {
        assertThatThrownBy(() -> {
            new Car("a", null);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
