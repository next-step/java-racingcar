package carRace.step5.domain.util;


import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.junit.jupiter.api.Assertions.*;

public class TryCountCheckTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("시도할 횟수 Null 또는 Empty 체크")
    void isNullCheckTryCountTest(String param) {
        assertThrows(NullPointerException.class, () -> {
            TryCountCheck.checkNumberValue(param);
        });
    }

    @Test
    @DisplayName("숫자인지 체크")
    void isNumberCheckTryCountTest() {
        assertThrows(NumberFormatException.class, () -> {
            TryCountCheck.checkNumberValue("asdf");
        });
    }
}
