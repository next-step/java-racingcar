package carRace.step5.domain.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarNamesCheckTest {


    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("자동차 이름 Null 또는 EMPTY  체크")
    void isEmptyInputCarNamesTest(String inputValue) {
        assertThrows(NullPointerException.class, () -> {
            CarNamesCheck.checkCarNames(inputValue);
        });
    }


    @Test
    @DisplayName("자동차 이름의 길이가 5초과하는지")
    void isGreaterThanFive() {
        assertThrows(IndexOutOfBoundsException.class, () -> {
            CarNamesCheck.checkCarNames("dsfadfasfdasdfads");
        });
    }

}
