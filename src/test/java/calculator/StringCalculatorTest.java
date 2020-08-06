package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @Test
    @DisplayName("연산식 계산 테스트")
    void calculate() {
        int[] numbers = {1, 10, 3};
        Operator[] operators = {Operator.PLUS, Operator.DIVIDE};

        assertEquals(StringCalculator.calculate(numbers, operators), 3);
    }

    @Test
    @DisplayName("연산자에 따른 피연산자 개수가 올바르지 않은 경우")
    void calculateWithIllegalArgumentException() {
        int[] numbers = {1, 10, 3};
        Operator[] operators = {Operator.PLUS};

        assertThatIllegalArgumentException().isThrownBy(() -> {
            int result = StringCalculator.calculate(numbers, operators);
        }).withMessage(ExceptionMessage.INCORRECT_NUMBER_OF_ARGUMENTS.getMessage());
    }
}
