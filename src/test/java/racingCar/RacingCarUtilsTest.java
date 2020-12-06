package racingCar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static racingCar.RacingCarUtils.checkCarNameRule;

public class RacingCarUtilsTest {
    String car = "helloworld";

    @Test
    @DisplayName("Check Car name rule")
    void exceed5Char() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {

                    checkCarNameRule(car);
                }).withMessageMatching("can not exceed 5 characters : " + car);
    }

}
