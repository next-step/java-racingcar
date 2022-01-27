package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import java.util.InputMismatchException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ExpressionParserTest {

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

    @Test
    void parseExpression_사용자_입력을_받아_Operators_Terms_생성() throws IOException {

        //given
        String userInput = "1 + 2 * 3";

        // when
        ExpressionParser parser = new ExpressionParser(userInput);

        // then
        assertThat(parser.getOperators()).isNotNull();
        assertThat(parser.getTerms()).isNotNull();
    }
}
