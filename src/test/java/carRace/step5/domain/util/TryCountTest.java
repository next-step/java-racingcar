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
            TryCount.checkNumberValue(null);
        });
    }

    @Test
    @EmptySource
    @DisplayName("시도할 횟수 EMPTY  체크")
    void isEmptyCheckTryCountTest() {
        assertThrows(NumberFormatException.class, () -> {
            TryCount.checkNumberValue("");
        });
    }

    @Test
    @DisplayName("숫자인지 체크")
    void isNumberCheckTryCountTest() {
        assertThrows(NumberFormatException.class, () -> {
            TryCount.checkNumberValue("asdf");
        });
    }
}
