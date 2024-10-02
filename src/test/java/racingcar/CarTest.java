package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @ParameterizedTest
    @CsvSource(value = {"-1", "10"})
    @DisplayName("0과 9사이의 범위를 벗어나면 예외 발생")
    void move_OutOfRangeException(int input) {
        assertThatThrownBy(() -> car.move(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"4:1", "5:1", "6:1", "7:1", "8:1", "9:1"}, delimiter = ':')
    @DisplayName("4이상인 경우, 자동차 전진")
    void move_forward(int input, int expected) {
        car.move(input);
        assertThat(car.getMoveCount()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:0", "2:0", "3:0"}, delimiter = ':')
    @DisplayName("4미만인 경우, 자동차 정지")
    void move_stop(int input, int expected) {
        car.move(input);
        assertThat(car.getMoveCount()).isEqualTo(expected);
    }
}
