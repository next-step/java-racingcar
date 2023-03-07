package study;

import caculator.Caculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CaculatorTest {
    @DisplayName("문자열 계산기 정상 작동을 확인해보자")
    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2 | 10.0"}, delimiter = '|')
    void caculator(final String string, final float result) {
        Caculator calculator = new Caculator();
        System.out.println(calculator.caculator(string));
        assertThat(calculator.caculator(string)).isEqualTo(result);
    }
}
