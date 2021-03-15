package study.calculator;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void 이항_덧셈을_테스트합니다() {
        //given
        int num1 = 10;
        int num2 = 5;

        //when
        int result = calculator.add(num1, num2);

        //then
        assertThat(result).isEqualTo(10 + 5);
    }

    @Test
    void 이항_뺄셈을_테스트합니다() {
        //given
        int num1 = 10;
        int num2 = 5;

        //when
        int result = calculator.subtract(num1, num2);

        //then
        assertThat(result).isEqualTo(10 - 5);
    }

    @Test
    void 이항_곱셈을_테스트합니다() {
        //given
        int num1 = 10;
        int num2 = 5;

        //when
        int result = calculator.multiply(num1, num2);

        //then
        assertThat(result).isEqualTo(10 * 5);
    }

    @Test
    void 이항_나눗셈을_테스트합니다() {
        //given
        int num1 = 10;
        int num2 = 5;

        //when
        int result = calculator.divide(num1, num2);

        //then
        assertThat(result).isEqualTo(10 / 5);
    }

    @Test
    void 입력값이_null일때_예외를_테스트합니다() {
        //given
        String input = null;

        //when
        ThrowableAssert.ThrowingCallable throwingCallable = () -> {
            int result = calculator.calculate(input);
        };

        //then
        Class expectedExceptionClass = IllegalArgumentException.class;
        assertThatThrownBy(throwingCallable).isInstanceOf(expectedExceptionClass);
    }

    @Test
    void 입력값이_빈_공백문자일때_예외를_테스트합니다() {
        //given
        String input = " ";

        //when
        ThrowableAssert.ThrowingCallable throwingCallable = () -> {
            int result = calculator.calculate(input);
        };

        //then
        Class expectedExceptionClass = IllegalArgumentException.class;
        assertThatThrownBy(throwingCallable).isInstanceOf(expectedExceptionClass);
    }

    @Test
    void 사칙연산_기호가_아닐때_예외를_테스트합니다() {
        //given
        String input = "&";

        //when
        ThrowableAssert.ThrowingCallable throwingCallable = () -> {
            int result = calculator.calculate(input);
        };

        //then
        Class expectedExceptionClass = IllegalArgumentException.class;
        assertThatThrownBy(throwingCallable).isInstanceOf(expectedExceptionClass);
    }

    @Test
    void 사칙연산을_모두_포함하는_테스트합니다() {
        //given
        String input = "2 + 3 * 4 / 2";

        //when
        int result = calculator.calculate(input);

        //then
        assertThat(result).isEqualTo(10);
    }
}
