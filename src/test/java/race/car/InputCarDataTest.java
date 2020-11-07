package race.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.junit.jupiter.api.Assertions.*;

public class InputCarDataTest {

    @Test
    @NullSource
    @DisplayName("시도할 횟수 Null  체크")
    void isNullCheckTryCountTest() {
        assertThrows(NullPointerException.class, () -> {
            InputCarData.checkTryCount(null);
        });
    }

    @Test
    @NullSource
    @DisplayName("자동차 이름 Null  체크")
    void isNullInputCarNamesTest() {
        assertThrows(NullPointerException.class, () -> {
            InputCarData.checkName(null);
        });
    }

    @Test
    @EmptySource
    @DisplayName("시도할 횟수 EMPTY  체크")
    void isEmptyCheckTryCountTest() {
        assertThrows(NumberFormatException.class, () -> {
            InputCarData.checkTryCount("");
        });
    }

    @Test
    @EmptySource
    @DisplayName("자동차 이름 EMPTY  체크")
    void isEmptyInputCarNamesTest() {
        assertThrows(NumberFormatException.class, () -> {
            InputCarData.checkName("");
        });
    }

    @Test
    @DisplayName("숫자인지 체크")
    void isNumberCheckTryCountTest() {
        assertThrows(NumberFormatException.class, () -> {
            InputCarData.checkTryCount("asdf");
        });
    }
}
