package racingcar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.ui.ParameterInput;
import racingcar.ui.RacingDataInput;

import static org.assertj.core.api.Assertions.assertThat;

public class InputTest {

    @ParameterizedTest
    @CsvSource(value = {"3:5", "2:4", "1:10"}, delimiter = ':')
    public void 값_입력(int numberOfCars, int tryCount) {

        RacingDataInput input = new ParameterInput(numberOfCars, tryCount);

        assertThat(input.getRacingData().getNumberOfCars()).isEqualTo(numberOfCars);
        assertThat(input.getRacingData().getTryCount()).isEqualTo(tryCount);
    }
}
