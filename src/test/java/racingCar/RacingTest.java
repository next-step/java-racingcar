package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {
    @DisplayName("경주 개최조건을 충족하지 않으면 경주는 개최하지않는다.")
    @ParameterizedTest
    @CsvSource(value = {"0:0", "3:0", "1:3"}, delimiter = ':')
    void Racing_개최조건_미충족(int inputCarCount, int inputRacingCount) {
        Racing racing = new Racing(inputCarCount, inputRacingCount);
        assertThat(racing.holdPossible()).isFalse();
    }

    @DisplayName("경주 개최조건을 충족하면 경주를 개최한다.")
    @ParameterizedTest
    @CsvSource(value = {"2:1", "4:3", "3:7"}, delimiter = ':')
    void Racing_개최조건_충족(int inputCarCount, int inputRacingCount) {
        Racing racing = new Racing(inputCarCount, inputRacingCount);
        assertThat(racing.holdPossible()).isTrue();
    }
}