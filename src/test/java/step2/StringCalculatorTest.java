package step2;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayDeque;
import java.util.Collection;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class StringCalculatorTest {
    StringCalculator stringCalculator = new StringCalculator();

    @ParameterizedTest
    @CsvSource(value = { "2, 3, 5.0" })
    @DisplayName("덧셈 테스트")
    void plus(double left, double right, String excepted) {
        String acutal = stringCalculator.plus(left, right);

        assertThat(acutal).isEqualTo(excepted);
    }

    @ParameterizedTest
    @CsvSource(value = { "2, 3, -1.0" })
    @DisplayName("뺄셈 테스트")
    void minus(double left, double right, String excepted) {
        String acutal = stringCalculator.minus(left, right);

        assertThat(acutal).isEqualTo(excepted);
    }

    @ParameterizedTest
    @CsvSource(value = { "2, 3, 6.0" })
    @DisplayName("곱셈 테스트")
    void multiply(double left, double right, String excepted) {
        String acutal = stringCalculator.multiply(left, right);

        assertThat(acutal).isEqualTo(excepted);
    }

    @ParameterizedTest
    @CsvSource(value = { "2, 4, 0.5" })
    @DisplayName("나눗셈 테스트")
    void division(double left, double right, String excepted) {
        String acutal = stringCalculator.division(left, right);

        assertThat(acutal).isEqualTo(excepted);
    }

    @Test
    @DisplayName("입력값이 null이거나 빈 공백 문자일 경우")
    void checkNull() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            stringCalculator.checkNull(null);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = { "", "  " })
    @DisplayName("입력값이 null이거나 빈 공백 문자일 경우")
    void checkEmpty(String param) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            stringCalculator.checkEmpty(param);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = { "+", "-", "*", "/" })
    @DisplayName("사칙연산 기호인 경우")
    void correctOperator(String operator) {
        stringCalculator.checkOperator(operator);
    }

    @ParameterizedTest
    @ValueSource(strings = { " ", "1", "a", "%" })
    @DisplayName("사칙연산 기호가 아닌 경우")
    void notCorrectOperator(String operator) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            stringCalculator.checkOperator(operator);
        });
    }

    @ParameterizedTest
    @CsvSource(value = { "2 + 3 * 4 / 2, 2+3*4/2", " a     a   a , aaa" })
    @DisplayName("공백 제거 테스트")
    void removeWhiteSpace(String param, String expected) {
        String actual = stringCalculator.removeWhiteSpace(param);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = { "2 + 3 * 4 / 2, 10" })
    @DisplayName("사칙연산을 모두 포함하는 테스트")
    void calculate(String param, String expected) {
        String actual = stringCalculator.calculate(param);
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = { "2 + 3 * 4 // 2" })
    @DisplayName("사칙연산이 실패하는 케이스")
    void calculateFail(String param) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            stringCalculator.calculate(param);
        });
    }

    @ParameterizedTest
    // csv가 복잡해진다면 어떻게하면좋은지
    @CsvSource(value = { "2+3*4/2, 2 + 3 * 4 / 2" })
    @DisplayName("계산기 초기화 테스트")
    void initCalculator(String param, String expectedStr) {
        ArrayDeque<String> calculatorDequeue = new ArrayDeque<>();
        
        // 뭐 틀렸는지
        ArrayDeque<String> expected = new ArrayDeque<>(
                (Collection) Arrays.asList(expectedStr.split(" ")));

        stringCalculator.initCalculatorDequeue(param, calculatorDequeue);

        assertThat(calculatorDequeue).containsExactlyElementsOf(expected);
    }
}
