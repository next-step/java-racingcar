package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculateFunctionTest {
    private CalculateFunction calculateFunction;

    @BeforeEach
    void setUp() {
        this.calculateFunction = new CalculateFunction();
    }

    @DisplayName("잘못된 연산자를 입력한 경우")
    @Test
    void getFunctionWithWrongExpression() {
        //given
        String expression = "?";
        int x = 1;
        int y = 2;

        //when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> calculateFunction.calculate(expression, x, y))
                .withMessage("잘못된 연산자입니다.");
    }

    @DisplayName("divide by zero")
    @Test
    void divideByZero() {
        //given
        String expression = "/";
        int x = 5;
        int y = 0;

        //when, then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> calculateFunction.calculate(expression, x, y))
                .withMessage("0으로 나눌수 없습니다.");
    }

    @DisplayName("사칙연산")
    @ParameterizedTest
    @CsvSource(value = {"+,10,2,12", "-,10,2,8", "*,2,4,8", "/,5,2,2"})
    void calculate(String expression, int x, int y, int expected) {
        //when
        int actual = calculateFunction.calculate(expression, x, y);

        //then
        assertEquals(expected, actual);
    }
}
