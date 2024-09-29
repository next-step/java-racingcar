package racingcar;

import exception.OutOfRangeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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
                .isInstanceOf(OutOfRangeException.class);
    }
}
