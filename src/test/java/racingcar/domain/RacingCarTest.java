package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RacingCarTest {

    @ParameterizedTest
    @DisplayName("경주차는 4이상의 수가 나오면 전진한다.")
    @CsvSource(value = {"4, 1", "3, 0"})
    void move(int randomNumber, int expectedPosition) {
        // given
        RacingCar racingCar = new RacingCar();

        // when
        racingCar.move(randomNumber);

        // then
        assertThat(racingCar).isEqualTo(new RacingCar(expectedPosition));
    }
}
