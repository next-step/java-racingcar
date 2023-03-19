package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OperationVerifierTest {

    @DisplayName("정상적인 문자열 입력")
    @ParameterizedTest
    @ValueSource(strings = {"1 * 2 + 3", "2 / 4 * 2"})
    void validExpression(String expression) {
        List<String> operands = OperationVerifier.verifyExpression(expression);
        assertEquals(operands.size(), 5);
    }

    @DisplayName("빈 값, null 값 입력")
    @ParameterizedTest
    @NullAndEmptySource
    void invalidExpression(String expression) {
        assertThrows(IllegalArgumentException.class, () -> {
            OperationVerifier.verifyExpression(expression);
        });
    }

    @DisplayName("올바르지 않은 수식 입력 확인")
    @ParameterizedTest
    @ValueSource(strings = {"1 * 3 +", "6 *"})
    void notMatchedExpression(String expression) {
        assertThrows(IllegalArgumentException.class, () -> {
            OperationVerifier.verifyExpression(expression);
        });
    }

    @DisplayName("유효한 피연산자 검증")
    @Test
    void validOperand() {
        String operand = "2";
        int actual = OperationVerifier.verifyOperand(operand);
        assertEquals(actual, 2);
    }

    @DisplayName("유효하지 않은 피연산자 검증")
    @ParameterizedTest
    @ValueSource(strings = {"a", "+"})
    void invalidOperand(String operand) {
        assertThrows(IllegalArgumentException.class, () -> {
            OperationVerifier.verifyOperand(operand);
        });
    }
}