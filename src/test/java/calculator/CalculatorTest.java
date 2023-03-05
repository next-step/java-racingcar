package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CalculatorTest {
    public Calculator cal;

    @BeforeEach
    void setup() {
        cal = new Calculator();
    }


    @DisplayName("계산기 Test")
    @ParameterizedTest(name = "[{displayName}_{index}] {0}={1}")
    @CsvSource({
            "'2 + 3 * 4 / 2', 10"
            ,"'10 * 22 / 8 + 12', 39.5"
            ,"'10 * 22 / 8 + 12 * 2 - 23 + 80', 136"
    })
    void calculatorTest(String data, double expected) {
        assertThat(cal.calculator(data)).isEqualTo(expected);
    }

    @DisplayName("사칙연산Test")
    @ParameterizedTest(name = "[{displayName}_{index}] {1}{0}{2}={3}")
    @CsvSource({
            "'+', 11, 22, 33"
            ,"'-', 20, 8,12"
            ,"'*', 7, 8, 56"
            ,"'/', 3, 2, 1.5"
    })
    void calculateTest(String calStr, double num1, double num2, double expected) {
        switch (calStr) {
            case "+" :
                assertThat(cal.plus(num1,num2)).isEqualTo(expected);
                break;
            case "-" :
                assertThat(cal.minus(num1,num2)).isEqualTo(expected);
                break;
            case "*" :
                assertThat(cal.multiply(num1,num2)).isEqualTo(expected);
                break;
            case "/" :
                assertThat(cal.divide(num1,num2)).isEqualTo(expected);
                break;
        }
    }

    @DisplayName("공백처리Test")
    @ParameterizedTest
    @ValueSource(strings = {"", "  "})
//    @NullSource
//    @EmptySource
    @NullAndEmptySource
    void isNullOrBlank(String input) {
        assertTrue(cal.isNullOrBlank(input));
    }

//    @DisplayName("사칙연산기호검증 Test")
//    @ParameterizedTest
////    @ValueSource(strings = {"+","@","-","*","/","^","%"})
//    @ValueSource(strings = {"+","-","*","/"})
//    void isCalStr(String operator) {
//        assertTrue(cal.isUsableOperators(operator));
//    }

}
