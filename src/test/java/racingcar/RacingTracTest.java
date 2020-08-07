package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTracTest {

    @ParameterizedTest
    @CsvSource(value={"3:3", "5:5"}, delimiter = ':')
    public void 레이싱개최(int countOfRacingCar, int countOfRacing) {
        assertThat(RacingTrac.getGameResult(countOfRacingCar, countOfRacing)).hasSize(countOfRacingCar);

        assertThat(
                Arrays.stream(RacingTrac.getGameResult(countOfRacingCar, countOfRacing))
                        .filter( racingCar -> racingCar == null)
        ).hasSize(0);
    }
}
