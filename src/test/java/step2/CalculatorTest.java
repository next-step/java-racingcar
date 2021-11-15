package step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @Test
    @DisplayName("Calculate 클래스 객체 생성시 예외를 던진다.")
    public void failToNewClass() throws NoSuchMethodException {
        Constructor<Calculator> constructor = Calculator.class.getDeclaredConstructor();
        constructor.setAccessible(true);

        assertThatThrownBy(() -> {
            constructor.newInstance();
        }).hasCauseInstanceOf(AssertionError.class)
                .hasStackTraceContaining("객체 생성이 불가능한");
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3, 5", "10 + 34, 44"})
    @DisplayName("plus 메서드는 2개의 유효한 인자가 제공될 경우, 두 값의 합을 반환한다.")
    public void plus(String input, int expected) {
        assertThat(Calculator.calculate(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 - 3, -1", "10 - 5, 5"})
    @DisplayName("minus 메서드는 2개의 유효한 인자가 제공될 경우, 두 값의 차를 반환한다.")
    public void minus(String input, int expected) {
        assertThat(Calculator.calculate(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 * 3, 6", "6 * 4, 24"})
    @DisplayName("multiply 메서드는 2개의 유효한 인자가 제공될 경우, 두 값의 곱을 반환한다.")
    public void multiply(String input, int expected) {
        assertThat(Calculator.calculate(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"4 / 2, 2", "10 / 2, 5"})
    @DisplayName("divide 메서드는 2개의 유효한 인자가 제공될 경우, 두 값의 몫을 반환한다.")
    public void divide(String input, int expected) {
        assertThat(Calculator.calculate(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"4 / 3", "9 / 4"})
    @DisplayName("나누어 떨어지지 않는 인자가 제공될 경우 예외를 던진다.")
    public void notDivide(String input) {
        assertThatThrownBy(() -> {
            Calculator.calculate(input);
        }).isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("나누어 떨어지지 않습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"3 / 0", "12 / 0"})
    @DisplayName("0으로 나눌 시 예외를 던진다.")
    public void notDivideByZero(String input) {
        assertThatThrownBy(() -> {
            Calculator.calculate(input);
        }).isInstanceOf(ArithmeticException.class)
                .hasMessage("0으로 나눌 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings= {"0 / 3", "0 / 34"})
    @DisplayName("0을 나눌 시 예외를 던진다.")
    public void zeroNotDivide(String input) {
        assertThatThrownBy(() -> {
            Calculator.calculate(input);
        }).isInstanceOf(ArithmeticException.class)
                .hasMessage("0은 나눌 수 없습니다.");
    }

    @Test
    @DisplayName("유효하지 않은 인자가 제공될 경우 예외를 던진다.")
    public void nullException() {
        String input = "  + 3";

        assertThatThrownBy(() -> {
            Calculator.calculate(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 숫자입니다.");
    }

    @ParameterizedTest
    @DisplayName("유효한 숫자 3개와 사칙연산 기호가 제공될 경우 정상적인 값이 반환된다.")
    @CsvSource(value={"1 + 2 * 3 : 9"}, delimiter = ':')
    public void calcMulti(String input, int expected) {
        int result = Calculator.calculate(input);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("유효한 숫자 여러개와 사칙연산 기호가 제공될 경우 정상적인 값이 반환된다.")
    @CsvSource(value={"1 + 2 * 3 / 3 + 5 - 2 * 10 + 3: 63"}, delimiter = ':')
    public void calcMulti2(String input, int expected) {
        int result = Calculator.calculate(input);

        Assertions.assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("유효하지 않은 인자가 제공될 경우 예외를 던진다.")
    @CsvSource(value={"1 + 2b * 3 / 3 + 5 - 2 * 10 + 3: 유효하지 않은"}, delimiter = ':')
    public void calcInvalidNumber(String input, String expected) {
        Assertions.assertThatThrownBy(() -> {
            Calculator.calculate(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expected);
    }

    @Test
    @DisplayName("유효하지 않은 사칙연산 기호가 제공될 경우 예외를 던진다.")
    public void calcInvalidOperator() {
        String input = "1 + 2 * 3 // 3 + 5";

        Assertions.assertThatThrownBy( () -> {
            Calculator.calculate(input);
        }).hasMessageContaining("유효하지 않은 사칙연산");
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("빈값이 제공될 경우 예외를 던진다.")
    public void valueNullAndEmpty(String input) {
        Assertions.assertThatThrownBy(() -> {
            Calculator.calculate(input);
        }).hasMessageContaining(MyException.EMPTY_INPUT.getMessage());
    }
}
