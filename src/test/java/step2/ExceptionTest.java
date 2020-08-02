package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExceptionTest {
    final String[] ARITHMETIC_EXPRESSION = {"+", "-", "/", "*"};

    boolean isStringEmpty(String testingValue) {
        try {
            if (testingValue.isBlank()) {
                throw new IllegalArgumentException("문자열이 공백 혹은 비어있습니다.");
            }

            return false;
        } catch (IllegalArgumentException exception) {

            System.err.println(exception.getMessage());
            return true;
        }
    }

    boolean isArithmeticExpression(String testingValue) {
        boolean result = false;

        try {
            for (String expression : ARITHMETIC_EXPRESSION) {
                if (testingValue.equals(expression)) {
                    result = true;
                    break;
                }
            }
            if (!result) {
                throw new IllegalArgumentException("사칙연산이 아니에요.");
            }

            return true;
        } catch (IllegalArgumentException exception) {

            System.err.println(exception.getMessage());
            return false;
        }
    }

    @ParameterizedTest
    @DisplayName("예외 테스트")
    @ValueSource(strings = {"+", " ", "^"})
    void exceptionTest(String inputValue) {
        assertThat(isStringEmpty(inputValue)).isFalse();
        assertThat(isArithmeticExpression(inputValue)).isTrue();
    }
}
