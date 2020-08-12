package racingcarbasic;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    RacingCar racingCar = new RacingCar();

    @ParameterizedTest
    @CsvSource(value = {"4, 5, 6, 7, 8, 9"}, delimiter = ',')
    void 전진(int num) {
        assertThat(racingCar.move(num)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"0, 1, 2, 3"}, delimiter = ',')
    void 멈춤(int num) {
        assertThat(racingCar.move(num)).isFalse();
    }
}
