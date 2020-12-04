package com.nextstep.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class ParserTest {
    private final Validator validator = new Validator();

    @DisplayName("잘못된 입력 값에 대한 정합성 검사 확인")
    @ParameterizedTest
    @CsvSource(value = {
            "'': Empty string is not valid argument",
            "+ 2 * 3 - 5: + 2 * 3 - 5 is not valid argument",
            "' 1 + 2 * 3 - 6': ' 1 + 2 * 3 - 6 is not valid argument'",
            "1+3: 1+3 is not number",
            "5 @ 3: @ is not valid operator. ( +, -, *, / )",
            "1 + 2 *: 1 + 2 * is not valid argument",
    }, delimiter = ':')
    public void checkValidate(String input, String message) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validator.validate(input))
                .withMessage(message);
    }
}
