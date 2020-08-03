package racingcar.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class InputTest {

    @DisplayName("ParameterInput 테스트")
    @ParameterizedTest
    @CsvSource(value = {"a,b,c:3:5", "a,b:2:4", "a:1:10"},
            delimiter = ':')
    public void parameterInputTest(String names, int numberOfCars, int tryCount) {

        RacingDataInput input = new ParameterInput(names, numberOfCars, tryCount);

        assertThat(input.getRacingData().getNumberOfCars()).isEqualTo(numberOfCars);
        assertThat(input.getRacingData().getTryCount()).isEqualTo(tryCount);
    }
}
