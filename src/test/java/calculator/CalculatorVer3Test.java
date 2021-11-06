package calculator;

import calculator.ver3.CalculatorVer3;
import calculator.ver3.MyNumberVer3;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

/**
 * version3 calculator
 * 단순 계산 테스트
 * 조건문 제거
 * MyNumber 객체 안 사칙연산 제거
 * Operation Enum class 사용
 */
public class CalculatorVer3Test {

    @Test
    void 덧셈() {
        MyNumberVer3 actual = CalculatorVer3.calculatorByMyNumber("1 + 2 + 3");
        assertThat(actual.getNumber()).isEqualTo(6);
    }

    @Test
    void 뺄셈() {
        MyNumberVer3 actual = CalculatorVer3.calculatorByMyNumber("3 - 2 - 1");
        assertThat(actual.getNumber()).isEqualTo(0);
    }

    @Test
    void 곱셈() {
        MyNumberVer3 actual = CalculatorVer3.calculatorByMyNumber("3 * 2 * 3 * 1");
        assertThat(actual.getNumber()).isEqualTo(18);
    }

    @Test
    void 나눗셈() {
        MyNumberVer3 actual = CalculatorVer3.calculatorByMyNumber("4 / 2 / 1");
        assertThat(actual.getNumber()).isEqualTo(2);

        assertThatThrownBy(() -> {
            CalculatorVer3.calculatorByMyNumber("4 / 0");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 사칙연산에러() {
        // 사칙연산 기호 에러 exception Throw
        assertThatThrownBy(() -> {
            CalculatorVer3.calculatorByMyNumber("4 & 2");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 연속사칙연산테스트() {
        MyNumberVer3 actual = CalculatorVer3.calculatorByMyNumber("2 + 3 * 4 / 2");
        assertThat(actual.getNumber()).isEqualTo(10);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    void isBlank_ShouldReturnTrueForNullOrBlankStrings(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            new MyNumberVer3(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

}
