package step2;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collection;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringCalculatorTest {
    StringCalculator stringCalculator = new StringCalculator();

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
        assertThat(stringCalculator.calculate(param)).isEqualTo("error");
    }

    @ParameterizedTest
    // csv가 복잡해진다면 어떻게하면좋은지
    @CsvSource(value = { "2+3*4/2, 2 + 3 * 4 / 2" })
    @DisplayName("계산기 초기화 테스트")
    void initCalculator(String param, String expectedStr) {
        ArrayDeque<String> calculatorDequeue = new ArrayDeque<>();

        // 뭐 틀렸는지
        ArrayDeque<String> expected = new ArrayDeque<>((Collection<String>) Arrays.asList(expectedStr.split(" ")));

        stringCalculator.initCalculatorDequeue(param, calculatorDequeue);

        assertThat(calculatorDequeue).containsExactlyElementsOf(expected);
    }

    @ParameterizedTest
    @CsvSource(value = { "2+3*4//2" })
    @DisplayName("계산기 초기화 테스트(잘못된수식입력)")
    void initCalculator_wrongOpertator(String param) {
        ArrayDeque<String> calculatorDequeue = new ArrayDeque<>();

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            stringCalculator.initCalculatorDequeue(param, calculatorDequeue);

        });
    }
}
