package racingcar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingDataTest {

    @ParameterizedTest
    @CsvSource(value = {"a,b,c:3:5", "a,b:2:4", "a:1:10"},
            delimiter = ':')
    public void makeObjectSuccess(String names, int numberOfCars, int tryCount) {

        RacingData racingData = new RacingData(names, numberOfCars, tryCount);

        assertThat(racingData.getNumberOfCars()).isEqualTo(numberOfCars);
        assertThat(racingData.getTryCount()).isEqualTo(tryCount);
    }
}
