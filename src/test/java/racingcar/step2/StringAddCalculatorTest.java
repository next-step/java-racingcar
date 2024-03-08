package racingcar.step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    StringAddCalculator stringAddCalculator;

    @BeforeEach
    void setUp() {
        stringAddCalculator = new StringAddCalculator(
                new DelimiterIntegerTokenizer(),
                new IntegerCalculator()
        );
    }

    @DisplayName("Null이나 빈값이 들어오면, 0을 반환한다.")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = { " ", "   ", "\t", "\n" })
    public void splitAndSum_null(String nullString) {
        // then
        assertThat(stringAddCalculator.splitAndSum(nullString)).isEqualTo(0);
    }

    @DisplayName("기본 구분자로 합계를 구한다.")
    @ParameterizedTest
    @CsvSource(value = {"^0", "1^1", "1,2^3", "1,2:3^6"}, delimiter = '^')
    public void splitAndSumParameterizedTest(String input, int result) {
        assertThat(stringAddCalculator.splitAndSum(input)).isEqualTo(result);
    }

    @DisplayName("사용자 정의 구분자로 합계를 구한다.")
    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = stringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("숫자 요소에 음수가 존재할 경우 IllegalArgumentException을 던진다.")
    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> stringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자 요소에 숫자가 아닌 요소가 존재할 경우 NumberFormatException을 던진다.")
    @Test
    public void splitAndSum_not_number() throws Exception {
        assertThatThrownBy(() -> stringAddCalculator.splitAndSum("-!,2,3"))
                .isInstanceOf(NumberFormatException.class);
    }
}
