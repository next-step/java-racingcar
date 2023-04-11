import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
public class StringCalculatorTest {

    private StringCalculator calculator = null;

    @BeforeEach
    public void beforeEach() {
        calculator = new StringCalculator();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3|6", "1:2:3|6", "1,2|3", "1|1"}, delimiter = '|')
    @DisplayName(",|: 구분자 sum 테스트")
    public void sumTest(String input, int result) {
        assertThat(calculator.sum(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3", "//@\n1@2@3", "//:\n1:2:3"})
    @DisplayName("커스텀 구분자가 존재하는 경우 sum 테스트")
    public void sumTest_customDelimiter(String input) {
        assertThat(calculator.sum(input)).isEqualTo(6);
    }

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈 문자열 혹은 null인 경우 sum 테스트")
    public void sumTest_nullOrBlank(String input) {
        assertThat(calculator.sum(input)).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"A,B,C", "-1,2,3"})
    @DisplayName("Exception 테스트")
    public void sumTest_exception(String input) {
        assertThatThrownBy(() -> calculator.sum(input)).isInstanceOf(RuntimeException.class);
    }
}
