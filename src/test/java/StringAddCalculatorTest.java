import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringAddCalculatorTest {


    @DisplayName("빈문자열 또는 null값을 입력한 경우 0을 반환한다. ")
    @ParameterizedTest
    @CsvSource(value = {"null,0", "'',0"}, nullValues = "null", emptyValue = "")
    void splitAndSumReturnZero(String input, Integer result) {
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(result);
    }

    @DisplayName("쉼표 또는 콜론 구분자 가지는 문자열이 전달될 경우 숫자를 합한다.")
    @ParameterizedTest
    @CsvSource(value = {"1,2,3-6", "1:2:3-6"}, delimiter = '-')
    void splitAndSum(String input, Integer result) {
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(result);
    }


    @DisplayName("앞의 기본 구분자(쉼표, 콜론)외에 커스텀 구분자를 지정할 수 있다.")
    @Test
    void splitAndSumWithCustomDelimiter() {
        String input = "//;\n1;2;3";
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(6);
    }
}
