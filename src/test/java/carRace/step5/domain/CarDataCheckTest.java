package carRace.step5.domain;

import carRace.step5.domain.util.CarDataCheck;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.junit.jupiter.api.Assertions.*;

public class CarDataCheckTest {
    private static CarDataCheck carDataCheck = new CarDataCheck();

    @Test
    @NullSource
    @DisplayName("시도할 횟수 Null  체크")
    void isNullCheckTryCountTest() {
        assertThrows(NullPointerException.class, () -> {
            carDataCheck.checkTryCount(null);
        });
    }

    @Test
    @NullSource
    @DisplayName("자동차 이름 Null  체크")
    void isNullInputCarNamesTest() {
        assertThrows(NullPointerException.class, () -> {
            carDataCheck.checkName(null);
        });
    }

    @Test
    @EmptySource
    @DisplayName("시도할 횟수 EMPTY  체크")
    void isEmptyCheckTryCountTest() {
        assertThrows(NumberFormatException.class, () -> {
            carDataCheck.checkTryCount("");
        });
    }

    @Test
    @EmptySource
    @DisplayName("자동차 이름 EMPTY  체크")
    void isEmptyInputCarNamesTest() {
        assertThrows(NumberFormatException.class, () -> {
            carDataCheck.checkName("");
        });
    }

    @Test
    @DisplayName("자동차 이름의 길이가 5초과하는지")
    void isGreaterThanFive() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            carDataCheck.checkName("dasasdasd");
        });
    }

    @Test
    @DisplayName("숫자인지 체크")
    void isNumberCheckTryCountTest() {
        assertThrows(NumberFormatException.class, () -> {
            carDataCheck.checkTryCount("asdf");
        });
    }
}
