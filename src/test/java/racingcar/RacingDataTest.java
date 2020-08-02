package racingcar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingDataTest {

    @ParameterizedTest
    @CsvSource(value = {"3:5", "2:4", "1:10"}, delimiter = ':')
    public void makeObjectSuccess(int numberOfCars, int tryCount) {

        RacingData racingData = new RacingData(numberOfCars, tryCount);

        assertThat(racingData.getNumberOfCars()).isEqualTo(numberOfCars);
        assertThat(racingData.getTryCount()).isEqualTo(tryCount);
    }
}
