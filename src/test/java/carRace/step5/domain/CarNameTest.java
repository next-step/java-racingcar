package carRace.step5.domain;

import carRace.step5.domain.util.CarNamesCheck;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.junit.jupiter.api.Assertions.*;

public class CarNameTest {


    @Test
    @NullSource
    @DisplayName("자동차 이름 Null  체크")
    void isNullInputCarNamesTest() {
        assertThrows(NullPointerException.class, () -> {
            CarNamesCheck.checkCarNames(null);
        });
    }

    @Test
    @EmptySource
    @DisplayName("자동차 이름 EMPTY  체크")
    void isEmptyInputCarNamesTest() {
        assertThrows(NumberFormatException.class, () -> {
            CarNamesCheck.checkCarNames("");
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
