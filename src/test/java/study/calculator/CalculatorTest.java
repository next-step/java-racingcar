package study.calculator;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    private Calculator calculator;

    @Test
    void 이항_덧셈을_테스트합니다() {
        //given
        String expressionString = "10 + 5";
        calculator = new Calculator(expressionString);

        //when
        int result = calculator.calculate();

        //then
        assertThat(result).isEqualTo(10 + 5);
    }

    @Test
    void 이항_뺄셈을_테스트합니다() {
        //given
        String expressionString = "10 - 5";
        calculator = new Calculator(expressionString);

        //when
        int result = calculator.calculate();

        //then
        assertThat(result).isEqualTo(10 - 5);
    }

    @Test
    void 이항_곱셈을_테스트합니다() {
        //given
        String expressionString = "10 * 5";
        calculator = new Calculator(expressionString);

        //when
        int result = calculator.calculate();

        //then
        assertThat(result).isEqualTo(10 * 5);
    }

    @Test
    void 이항_나눗셈을_테스트합니다() {
        //given
        String expressionString = "10 / 5";
        calculator = new Calculator(expressionString);

        //when
        int result = calculator.calculate();

        //then
        assertThat(result).isEqualTo(10 / 5);
    }

    @Test
    void 입력값이_null일때_예외를_테스트합니다() {
        //given
        String expressionString = null;

        //when
        ThrowableAssert.ThrowingCallable throwingCallable = () -> {
            calculator = new Calculator(expressionString);
            int result = calculator.calculate();
        };

        //then
        Class expectedExceptionClass = IllegalArgumentException.class;
        assertThatThrownBy(throwingCallable).isInstanceOf(expectedExceptionClass);
    }

    @Test
    void 입력값이_빈_공백문자일때_예외를_테스트합니다() {
        //given
        String expressionString = " ";

        //when
        ThrowableAssert.ThrowingCallable throwingCallable = () -> {
            calculator = new Calculator(expressionString);
            int result = calculator.calculate();
        };

        //then
        Class expectedExceptionClass = IllegalArgumentException.class;
        assertThatThrownBy(throwingCallable).isInstanceOf(expectedExceptionClass);
    }

    @Test
    void 사칙연산_기호가_아닐때_예외를_테스트합니다() {
        //given
        String expressionString = "5 & 2";
        calculator = new Calculator(expressionString);

        //when
        ThrowableAssert.ThrowingCallable throwingCallable = () -> {
            int result = calculator.calculate();
        };

        //then
        Class expectedExceptionClass = IllegalArgumentException.class;
        assertThatThrownBy(throwingCallable).isInstanceOf(expectedExceptionClass);
    }

    @Test
    void 사칙연산을_모두_포함하는_테스트합니다() {
        //given
        String expressionString = "2 + 3 * 4 / 2";
        calculator = new Calculator(expressionString);

        //when
        int result = calculator.calculate();

        //then
        assertThat(result).isEqualTo(10);
    }
}
