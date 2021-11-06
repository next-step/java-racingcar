package calculator;

import calculator.ver2.CalculatorVer2;
import calculator.ver2.MyNumberVer2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

/**
 * version2 calculator
 * 단순 계산 테스트
 * 조건문 사용
 * MyNumber 객체 사용
 */
public class CalculatorVer2Test {

    @Test
    void create() {
        MyNumberVer2 number = new MyNumberVer2(1);
        assertThat(number.getNumber()).isEqualTo(1);
        assertThat(number.has(1)).isTrue();
        assertThat(new MyNumberVer2("1").getNumber()).isEqualTo(new MyNumberVer2(1).getNumber());
    }

    @Test
    void 덧셈() {
        MyNumberVer2 actual = CalculatorVer2.calculatorByMyNumber("1 + 2 + 3");
        assertThat(actual.getNumber()).isEqualTo(6);
    }

    @Test
    void 뺄셈() {
        MyNumberVer2 actual = CalculatorVer2.calculatorByMyNumber("3 - 2 - 1");
        assertThat(actual.getNumber()).isEqualTo(0);
    }

    @Test
    void 곱셈() {
        MyNumberVer2 actual = CalculatorVer2.calculatorByMyNumber("3 * 2 * 3 * 1");
        assertThat(actual.getNumber()).isEqualTo(18);
    }

    @Test
    void 나눗셈() {
        MyNumberVer2 actual = CalculatorVer2.calculatorByMyNumber("4 / 2 / 1");
        assertThat(actual.getNumber()).isEqualTo(2);

        assertThatThrownBy(() -> {
            CalculatorVer2.calculatorByMyNumber("4 / 0");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new MyNumberVer2(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
