package study2;

import calculator.StringCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("2단계 - 문자열 계산기")
public class StringCalculatorTest {

    @DisplayName("덧셈")
    @ParameterizedTest
    @ValueSource(strings = {"20 + 1"})
    void testPlus(String inputString) {
        assertThat(StringCalculator.create().computerCalculator(inputString)).isEqualTo(21);
        ;
    }

    @DisplayName("뺄셈")
    @ParameterizedTest
    @ValueSource(strings = {"20 - 1"})
    void testMinus(String inputString) {
        assertThat(StringCalculator.create().computerCalculator(inputString)).isEqualTo(19);
        ;
    }

    @DisplayName("곱셈")
    @ParameterizedTest
    @ValueSource(strings = {"20 * 1"})
    void testMultiply(String inputString) {
        assertThat(StringCalculator.create().computerCalculator(inputString)).isEqualTo(20);
        ;
    }

    @DisplayName("나눗셈")
    @ParameterizedTest
    @ValueSource(strings = {"20 / 5"})
    void testDivide(String inputString) {
        assertThat(StringCalculator.create().computerCalculator(inputString)).isEqualTo(4);
        ;
    }

    @DisplayName("문자열 계산기")
    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 / 2"})
    void testCalculator(String inputString) {
        assertThat(StringCalculator.create().computerCalculator(inputString)).isEqualTo(10);
        ;
    }

    @DisplayName("사칙연산자 이외 문자 입력시 Exception")
    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 * 4 # 2"})
    void testCalculatorException(String inputString) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    StringCalculator.create().computerCalculator(inputString);
                }) ;
    }

    @DisplayName("0으로 나누기 Exception")
    @ParameterizedTest
    @ValueSource(strings = {"20 / 0"})
    void testCalculatorDivideByZeroException(String inputString) {
        assertThatExceptionOfType(ArithmeticException.class)
                .isThrownBy(() -> {
                    StringCalculator.create().computerCalculator(inputString);
                }) ;
    }

}
