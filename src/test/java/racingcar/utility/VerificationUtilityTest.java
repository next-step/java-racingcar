package racingcar.utility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static racingcar.utility.VerificationUtility.validateAttempt;
import static racingcar.utility.VerificationUtility.validateCarName;

public class VerificationUtilityTest {
    @Test
    @DisplayName("한 글자 미만")
    public void lessthan1CharacterTest() {
        //given
        String name = "";

        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> validateCarName(name));
    }

    @Test
    @DisplayName("다섯 글자 이상")
    public void morethan5CharacterTest() {
        //given
        String name = "eli string test";

        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> validateCarName(name));
    }

    @Test
    @DisplayName("공백 테스트")
    public void blankTest() {
        //given
        String name = "eli black test";

        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> validateCarName(name));
    }

    @Test
    @DisplayName("정수테스트")
    public void integerTest() {
        // given
        String attempt = "숫자";

        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> validateAttempt(attempt));
    }

    @Test
    @DisplayName("음수테스트")
    public void negativeTest() {
        // given
        String attempt = "-3";

        //then
        Assertions.assertThrows(IllegalArgumentException.class, () -> validateAttempt(attempt));
    }
}
