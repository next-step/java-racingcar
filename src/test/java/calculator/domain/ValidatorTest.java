package calculator.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.InputMismatchException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    @ValueSource(strings = {"", " ", "    "})
    @ParameterizedTest
    void checkIsBlank_입력으로_공백이_들어옴(String blank) {

        // then
        assertThrows(IllegalArgumentException.class, () -> Validator.checkIsBlack(blank));
    }

    @Test
    void checkIsBlank_공백이_아님() {

        // then
        assertDoesNotThrow(() -> Validator.checkIsBlack("1 + 2"));
    }


    @Test
    void 숫자이다_성공() {

        // then
        assertDoesNotThrow(() -> Validator.validateIsNumber("1"));
    }

    @Test
    void 숫자이다_실패_숫자가아님() {

        // then
        assertThrows(InputMismatchException.class, () -> Validator.validateIsNumber("+"));
    }

    @ValueSource(strings = {"+", "-", "*", "/"})
    @ParameterizedTest
    void 연산자이다_성공(String operator) {

        // then
        assertDoesNotThrow((() -> Validator.validateIsOperator(operator)));
    }

    @Test
    void 연산자이다_실패_연산자가_아님() {

        // then
        assertThrows(InputMismatchException.class, () -> Validator.validateIsOperator("1"));
    }
}