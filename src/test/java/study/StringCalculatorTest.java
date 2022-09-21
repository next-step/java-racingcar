package study;

import calculator.StringCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;

public class StringCalculatorTest {

    private static StringCalculator calculator = new StringCalculator();

    @ParameterizedTest
    @DisplayName("문자열에 있는 숫자들의 합을 계산 (숫자 구분자는 ':' 또는 ',')")
    @CsvSource(useHeadersInDisplayName = true, textBlock = """
        VALUES,  SUM
        '1',     1
        '1,2',   3
        '1:2,3', 6
    """)
    void calculateString(String value, int expected) {
        assertThat(calculator.calculate(value)).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("빈값인 경우 0으로 계산")
    @NullAndEmptySource()
    @ValueSource(strings = {" "})
    void calculateEmptyString(String value) {
        assertThat(calculator.calculate(value)).isEqualTo(0);
    }

    @ParameterizedTest
    @DisplayName("문자열 앞부분의 //와 \n 사이에 위치한 문자를 구분자로 채택")
    @CsvSource(useHeadersInDisplayName = true, textBlock = """
        VALUES,      SUM
        '//?\n1?2',  3
        '//+\n   1', 1
        '//+\n',     0
    """)
    void calculateStringByCustomDelimiter(String value, int expected) {
        assertThat(calculator.calculate(value)).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("숫자 이외 값 또는 음수가 들어가면 RuntimeException 예외 발생")
    @ValueSource(strings = {"a,1", "2,-1", "//?\n1?-2"})
    void calculateStringException(String value) {
        Throwable thrown = catchThrowable(() -> { calculator.calculate(value); });
        assertThat(thrown).hasMessageContaining("%s: only positive number allowed", value.replaceAll("//.\n", ""));
    }
}
