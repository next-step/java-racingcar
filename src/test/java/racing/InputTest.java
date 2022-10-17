package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.RacingGameInfo;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static racing.UserInputException.isValidForNumber;

public class InputTest {

    @Test
    @DisplayName("자동차 이름은 5자를 초과할 수 없다")
    void carNameException() {
        assertDoesNotThrow(() -> new RacingGameInfo().split("pobi,crong,honux"));

        assertThatThrownBy(() -> new RacingGameInfo().split("pobi,crong,honuxx"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("자동차 이름은 쉼표(,)를 기준으로 구분한다")
    void carNameSeparator() {
        String[] expected = {"pobi","crong","honux"};
        assertEquals(expected, new RacingGameInfo().split("pobi,crong,honux"));
    }

    @Test
    @DisplayName("[예외] 숫자 이외의 값을 전달하는 경우")
    void isNumber() {
        assertThatThrownBy(() -> isValidForNumber("#"))
                .isInstanceOf(NumberFormatException.class);
    }

    @Test
    @DisplayName("[예외] 음수를 전달하는 경우")
    void negative() {
        assertThatThrownBy(() -> isValidForNumber("-1"))
                .isInstanceOf(RuntimeException.class);
    }
}