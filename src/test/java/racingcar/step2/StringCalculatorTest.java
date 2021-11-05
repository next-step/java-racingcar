package racingcar.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingcar.step2.operation.*;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {

    @Test
    @DisplayName("문자열 쪼개서 배열로 반환")
    void blankSplit() {
        String[] strings = CalculatorUtil.blankSplit("2 + 3");
        assertThat(strings).containsExactly("2", "+", "3");
    }

    @Test
    @DisplayName("덧셈")
    void sum() {
        Operation operation = new Sum("2", "3");
        assertThat(operation.operate()).isEqualTo("5");
    }

    @Test
    @DisplayName("뺄셈")
    void minus() {
        Operation operation= new Minus("2", "3");
        assertThat(operation.operate()).isEqualTo("-1");
    }

    @Test
    @DisplayName("곱셈")
    void multiply() {
        Operation operation = new Multiply("2", "3");
        assertThat(operation.operate()).isEqualTo("6");
    }

    @Test
    @DisplayName("나누기")
    void divide() {
        Operation operation = new Divide("4", "2");
        assertThat(operation.operate()).isEqualTo("2");
    }

    @DisplayName("정수 나누기 검증 - by zero / 정수로 떨어지는 값")
    @Test
    void divideCheck() {
        assertThatThrownBy(() -> {
            CalculatorValidation.divideCheck(3, 2);
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            CalculatorValidation.divideCheck(3, 0);
        }).isInstanceOf(IllegalArgumentException.class);
        // 입력값이 정상
        assertThatCode(() -> {
            CalculatorValidation.divideCheck(4, 2);
        }).doesNotThrowAnyException();
    }

    @DisplayName("입력값이 null or 빈 공백인지 검중")
    @Test
    void nullOrBlank() {
        String[] strArr =  CalculatorUtil.blankSplit("2 +   1");
        assertThatThrownBy(() -> {
            CalculatorValidation.nullOrBlankCheck(strArr);
        }).isInstanceOf(IllegalArgumentException.class);
        // 입력값이 정상
        assertThatCode(() -> {
            CalculatorValidation.nullOrBlankCheck( CalculatorUtil.blankSplit("2 + 3"));
        }).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("입력값이 사친연산인지 검증")
    void arithmeticCheck() {
        String[] strings =  CalculatorUtil.blankSplit("2 & 3");
        assertThatThrownBy(() -> {
            CalculatorValidation.arithmeticCheck(strings);
        }).isInstanceOf(IllegalArgumentException.class);
        // 입력값이 정상
        assertThatCode(() -> {
            CalculatorValidation.nullOrBlankCheck(CalculatorUtil.blankSplit("2 * 3"));
        }).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @DisplayName("문자열 사칙연산 계산")
    @CsvSource(value = {
            "2 + 3 : 5",
            "2 + 3 * 4 / 2 : 10"}, delimiter = ':')
    void calculate2(String input, String result) {
        String[] strings = CalculatorUtil.blankSplit(input);
        CalculatorValidation.integratedCheck(strings);
        StringCalculator stringCalculator = new StringCalculator();
        assertThat(stringCalculator.calculate(strings)).isEqualTo(result);
    }

}
