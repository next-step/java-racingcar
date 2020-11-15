package carRace.step5.domain.util;


import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.junit.jupiter.api.Assertions.*;

public class TryCountTest {

    @Test
    @NullSource
    @DisplayName("시도할 횟수 Null  체크")
    void isNullCheckTryCountTest() {
        assertThrows(NullPointerException.class, () -> {
            TryCountValueCheck.checkNumberValue(null);
        });
    }

    @Test
    @EmptySource
    @DisplayName("시도할 횟수 EMPTY  체크")
    void isEmptyCheckTryCountTest() {
        assertThrows(NumberFormatException.class, () -> {
            TryCountValueCheck.checkNumberValue("");
        });
    }

    @Test
    @DisplayName("숫자인지 체크")
    void isNumberCheckTryCountTest() {
        assertThrows(NumberFormatException.class, () -> {
            TryCountValueCheck.checkNumberValue("asdf");
        });
    }

    @Test
    @DisplayName("음수인지 체크")
    void isNumberCheckTryCountTest() {
        assertThrows(NumberFormatException.class, () -> {
            TryCountValueCheck.checkNumberValue("asdf");
        });
    }
}
