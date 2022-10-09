package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    RacingCar racingCar = new RacingCar(3);

    @DisplayName("0~9 랜덤한 숫자 가져오기")
    @Test
    void randomNumberTest() {
        assertThat(racingCar.randomNumber()).isBetween(0, 9);
    }

    @ParameterizedTest(name = "{0}go/stop 판별하기")
    @CsvSource(value = {"0:0", "1:0", "2:0", "3:0", "4:1", "5:1", "6:1", "7:1", "8:1", "9:1"}, delimiter = ':')
    void goStopTest(String input, String result) {
        assertThat(racingCar.goStop(Integer.parseInt(input))).isEqualTo(Integer.parseInt(result));
    }

    @DisplayName("자동차 움직임 출력")
    @Test
    void carMovePrintTest() {
        assertThat(racingCar.carMovePrint(5)).isEqualTo("-----");
    }
}
