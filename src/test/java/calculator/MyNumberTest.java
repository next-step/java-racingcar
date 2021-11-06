package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class MyNumberTest {

    @Test
    void create() {
        MyNumber number = new MyNumber(1);
        assertThat(number.getNumber()).isEqualTo(1);
        assertThat(number.has(1)).isTrue();
        assertThat(new MyNumber("1").getNumber()).isEqualTo(new MyNumber(1).getNumber());
    }

    @Test
    void plusMethod() {
        MyNumber actual = new MyNumber("1").plus(new MyNumber("2"));
        assertThat(actual.getNumber()).isEqualTo(3);
    }

    @Test
    void minusMethod() {
        MyNumber actual = new MyNumber("3").minus(new MyNumber(2));
        assertThat(actual.getNumber()).isEqualTo(1);
    }

    @Test
    void multipleMethod() {
        MyNumber actual = new MyNumber("2").multiple(new MyNumber(2));
        assertThat(actual.getNumber()).isEqualTo(4);
    }

    @Test
    void divideMethod() {
        MyNumber actual = new MyNumber("4").divide(new MyNumber(2));
        assertThat(actual.getNumber()).isEqualTo(2);
    }

    @Test
    void 덧셈() {
        MyNumber actual = Calculator.calculatorByMyNumber("1 + 2");
        assertThat(actual.getNumber()).isEqualTo(3);
    }

    @Test
    void 뺄셈() {
        MyNumber actual = Calculator.calculatorByMyNumber("3 - 2");
        assertThat(actual.getNumber()).isEqualTo(1);
    }

    @Test
    void 곱셈() {
        MyNumber actual = Calculator.calculatorByMyNumber("3 * 2");
        assertThat(actual.getNumber()).isEqualTo(6);
    }

    @Test
    void 나눗셈() {
        MyNumber actual = Calculator.calculatorByMyNumber("4 / 2");
        assertThat(actual.getNumber()).isEqualTo(2);

        assertThatThrownBy(() -> {
            Calculator.calculatorByMyNumber("4 / 0");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사칙연산에러() {
        // 사칙연산 기호 에러 exception Throw
        assertThatThrownBy(() -> {
            Calculator.calculatorByMyNumber("4 & 2");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 연속사칙연산테스트() {
        MyNumber actual = Calculator.calculatorByMyNumber("2 + 3 * 4 / 2");
        assertThat(actual.getNumber()).isEqualTo(10);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new MyNumber(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }


}
