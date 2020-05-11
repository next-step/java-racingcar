package calculator;

import calculator.exception.ErrorMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = Calculator.of();
    }

    @DisplayName("Calculator 생성 확인")
    @Test
    void create() {
        assertThatCode(Calculator::of).doesNotThrowAnyException();
    }

    @DisplayName("입력 값이 null 이거나 빈 공백 문자일 경우 IllegalArgumentException 에러 발생")
    @ParameterizedTest
    @NullAndEmptySource
    void isNullOrEmpty(final String value) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> calculator.run(value))
                .withMessageContaining(ErrorMessage.IS_NULL_OR_EMPTY);
    }
}
