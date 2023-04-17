package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.CarNamesLimit;

import static org.assertj.core.api.Assertions.assertThat;

public class CarNamesLimitTest {
    @Test
    @DisplayName("입력한 자동차 이름이 5글자를 초과할 경우 return true")
    public void checkRacingCarsNamesOverFiveString_ReturnTrue() {
        CarNamesLimit carNamesLimit = new CarNamesLimit();
        boolean result = carNamesLimit.checkOverCarNameLimit("testtest");

        assertThat(result).isTrue();
    }
}
