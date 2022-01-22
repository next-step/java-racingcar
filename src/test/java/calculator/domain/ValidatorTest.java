package calculator.domain;

import static org.junit.jupiter.api.Assertions.*;

import com.ginsberg.junit.exit.ExpectSystemExit;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {

    @Test
    void 입력으로_공백이_들어옴_실패() {

        // then
        assertThrows(IllegalArgumentException.class, () -> Validator.checkIsBlack(""));
    }

    @Test
    void 숫자이다_성공() {

        // then
        assertDoesNotThrow(() -> Validator.validateIsNumber("1"));
    }

    @Test
    void 숫자이다_실패_숫자가아님() {

        // then
        assertThrows(IllegalArgumentException.class, () -> Validator.validateIsNumber("+"));
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