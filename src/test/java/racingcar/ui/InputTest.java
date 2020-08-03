package racingcar.ui;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.ui.ParameterInput;
import racingcar.ui.RacingDataInput;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

public class InputTest {

    @DisplayName("ParameterInput 테스트")
    @ParameterizedTest
    @CsvSource(value = {"3:5", "2:4", "1:10"}, delimiter = ':')
    public void parameterInputTest(int numberOfCars, int tryCount) {

        RacingDataInput input = new ParameterInput(numberOfCars, tryCount);

        assertThat(input.getRacingData().getNumberOfCars()).isEqualTo(numberOfCars);
        assertThat(input.getRacingData().getTryCount()).isEqualTo(tryCount);
    }
}
