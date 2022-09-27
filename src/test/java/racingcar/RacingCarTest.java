package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    RacingCar racingCar = new RacingCar();

    @DisplayName("0~9 랜덤한 숫자 가져오기")
    @Test
    void randomNumberTest() {
        assertThat(racingCar.randomNumber()).isBetween(0, 9);
    }

    @ParameterizedTest(name = "{0}go/stop 판별하기")
    @CsvSource(value = {"0:false", "1:false", "2:false", "3:false", "4:true", "5:true", "6:true", "7:true", "8:true", "9:true"}, delimiter = ':')
    void goStopTest(String input, String result) {
        assertThat(racingCar.goStop(Integer.parseInt(input))).isEqualTo(Boolean.parseBoolean(result));
    }
}
