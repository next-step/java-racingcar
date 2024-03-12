package racingCar.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class UtilsTest {
    @Test
    @DisplayName("0이하의 수 입력시 에러")
    void non_positive_input() {
        Utils utils = new Utils();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            utils.toInt("-1");
        });
    }

    @Test
    @DisplayName("숫자가 아닌 값 입력시 에러")
    void non_math_input() {
        Utils utils = new Utils();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            utils.toInt("hi");
        });
    }

    @Test
    @DisplayName("너무 긴 이름은 에러")
    void too_long_name() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Utils.checkUsableName("imWinner");
        });
    }


}
