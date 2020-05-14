import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalcTest {
    Calculator calculator = new Calculator();

    @DisplayName("조건에 맞는 문자열을 입력 받았을 때")
    @ParameterizedTest
    @CsvSource(value = {"1 + 2 + 3 = 6.0", "4 + 2 / 3 = 2", "2 + 3 * 4 / 2 = 10"}, delimiter = '=')
    void testCalcRight(String testStr, String expected) {
        assertEquals(calculator.calculate(testStr), Double.parseDouble(expected));
    }

    @DisplayName("공백인 문자열을 입력 받았을 때")
    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {"", "   ", "\t", "\n"})
    void testEmptyString(String testStr) {
        assertThatThrownBy(() -> calculator.calculate(testStr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("this is empty string");
    }

    @DisplayName("숫자나 사칙연산 외에 다른 문자가 들어온 경우 ")
    @ParameterizedTest
    @ValueSource(strings = {"a b c", " 2 + 3 * # 4 / ( 2", "4 % b + c"})
    void testCalcWrong(String testStr) {
        assertThatThrownBy(() -> calculator.calculate(testStr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("you are allow to use only number or arithmetic operation");
    }

    @DisplayName("처음과 끝이 숫자가 아닌 경우 ")
    @ParameterizedTest
    @ValueSource(strings = {"1 + 2 + ", " + 2 / 3", " / 0 + "})
    void testStartEndIsNum(String testStr) {
        assertThatThrownBy(() -> calculator.calculate(testStr))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("start and end char must be number to calculate");
    }

    @Test
    void testDivideBy0() {
        assertThatThrownBy(() -> calculator.divisionOperation(1, 0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("you can't divide by 0");
    }
}
