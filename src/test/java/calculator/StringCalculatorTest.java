package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static calculator.StringCalculator.splitAndSum;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    @DisplayName("“//”와 “\\n” 문자 사이에 커스텀 구분자를 지정할 수 있다.")
    @Test
    void 커스텀구분자() {
        assertThat(splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생해야 한다.")
    @Test
    void 음수() {
        assertThatThrownBy(() -> splitAndSum("-1,2:3")).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest(name = "구분자를 컴마(,) 콜론(:)을 사용할 수 있다. ")
    @CsvSource(value = {"1,2:3|6", "1,3:4|8"}, delimiter = '|')
    void 콜론구분자(String input, int expected) {
        assertThat(splitAndSum(input)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    @CsvSource(value = {"1,2:3", "3,4:7"}, delimiter = ':')
    void 컴마구분자(String input, int expected) {
        assertThat(splitAndSum(input)).isEqualTo(expected);
    }

    @ParameterizedTest(name = "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다.")
    @CsvSource(value = {"1:1", "3:3"}, delimiter = ':')
    void 숫자_하나(String input, int expected) {
        assertThat(splitAndSum(input)).isEqualTo(expected);
    }

    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다.")
    @Test
    void 빈문자열_null() {
        assertThat(splitAndSum(null)).isEqualTo(0);
        assertThat(splitAndSum("")).isEqualTo(0);
    }
}
