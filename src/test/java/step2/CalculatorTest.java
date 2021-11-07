package step2;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

    @Test
    @DisplayName("2개의 숫자를 더한 값이 정상적으로 출력된다.")
    public void plus() {
        String input1 = "2 + 3";
        String input2 = "10 + 34";

        assertThat(Calculator.calculate(input1)).isEqualTo(5);
        assertThat(Calculator.calculate(input2)).isEqualTo(44);
    }

    @Test
    @DisplayName("2개의 숫자를 뺀 값이 정상적으로 출력된다.")
    public void minus() {
        String input1 = "2 - 3";
        String input2 = "10 - 5";

        assertThat(Calculator.calculate(input1)).isEqualTo(-1);
        assertThat(Calculator.calculate(input2)).isEqualTo(5);
    }

    @Test
    @DisplayName("2개의 숫자를 곱한 값이 정상적으로 출력된다.")
    public void multiply() {
        String input1 = "2 * 3";
        String input2 = "6 * 4";

        assertThat(Calculator.calculate(input1)).isEqualTo(6);
        assertThat(Calculator.calculate(input2)).isEqualTo(24);
    }

    @Test
    @DisplayName("2개의 숫자를 나눈 값이 정상적으로 출력된다.")
    public void divide() {
        String input1 = "4 / 2";
        String input2 = "10 / 2";

        assertThat(Calculator.calculate(input1)).isEqualTo(2);
        assertThat(Calculator.calculate(input2)).isEqualTo(5);
    }

    @Test
    @DisplayName("나누어 떨어지지 않는 나눗셈 연산으로 예외를 던진다.")
    public void notDivide() {
        String input = "4 / 3";

        assertThatThrownBy(() -> {
            Calculator.calculate(input);
        }).isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("나누어 떨어지지 않습니다.");
    }

    @Test
    @DisplayName("0으로 나눌 시 [0으로 나눌 수 없다]는 예외를 던진다.")
    public void notDivideByZero() {
        String input1 = "3 / 0";
        String input2 = "33 / 0";

        assertThatThrownBy(() -> {
            Calculator.calculate(input1);
            Calculator.calculate(input2);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0으로 나눌 수 없습니다.");
    }

    @Test
    @DisplayName("0을 나눌 시 [0은 나눌 수 없다]는 예외를 던진다.")
    public void zeroNotDivide() {
        String input1 = "0 / 3";
        String input2 = "0 / 34";

        assertThatThrownBy(() -> {
            Calculator.calculate(input1);
            Calculator.calculate(input2);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("0은 나눌 수 없습니다.");
    }

    @Test
    @DisplayName("값이 유효하지 않을 경우 예외를 던진다.")
    public void nullException() {
        String input = "  + 3";

        assertThatThrownBy(() -> {
            Calculator.calculate(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("유효하지 않은 숫자입니다.");
    }

    @ParameterizedTest
    @DisplayName("유효한 숫자 3개와 사칙연산 기호를 사용하여 정상인 값이 출력된다.")
    @CsvSource(value={"1 + 2 * 3 : 9"}, delimiter = ':')
    public void calcMulti(String input, int expected) {
        MyNumber result = Calculator.calculateMulti(input);

        Assertions.assertThat(result.getNumber()).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("유효한 숫자 여러개와 사칙연산 기호로 연산하여 정상인 값이 출력된다.")
    @CsvSource(value={"1 + 2 * 3 / 3 + 5 - 2 * 10 + 3: 63"}, delimiter = ':')
    public void calcMulti2(String input, int expected) {
        MyNumber result = Calculator.calculateMulti(input);

        Assertions.assertThat(result.getNumber()).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("잘못된 숫자 입력시 [유효하지 않은 숫자] 예외를 던진다.")
    @CsvSource(value={"1 + 2b * 3 / 3 + 5 - 2 * 10 + 3: 유효하지 않은"}, delimiter = ':')
    public void calcInvalidNumber(String input, String expected) {
        Assertions.assertThatThrownBy(() -> {
            Calculator.calculateMulti(input);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(expected);
    }

    @Test
    @DisplayName("유효하지 않은 사칙연산 기호로 [유효하지 않은 사칙연산] 예외를 던진다.")
    public void calcInvalidOperator() {
        String input = "1 + 2 * 3 // 3 + 5";

        Assertions.assertThatThrownBy( () -> {
            Calculator.calculateMulti(input);
        }).hasMessageContaining("유효하지 않은 사칙연산");
    }

    @ParameterizedTest
    @EmptySource
    @DisplayName("빈값을 입력하면 [빈 값 입력] 예외를 던진다.")
    public void valueNullAndEmpty(String input) {
        Assertions.assertThatThrownBy(() -> {
            Calculator.calculate(input);
        }).hasMessageContaining(MyException.EMPTY_INPUT.getMessage());
    }
}
