package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("빈문자열이나 널일때")
    void emptyStringOrNullTest(String input) {
        assertThat(StringAndCalculator.splitAndSum(input)).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환")
    void OneStringTest() {
        assertThat(StringAndCalculator.splitAndSum("1")).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환")
    void commaTest() {
        assertThat(StringAndCalculator.splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용")
    void colonTest() {
        assertThat(StringAndCalculator.splitAndSum("1:2,3")).isEqualTo(6);
    }

    @Test
    @DisplayName("“//”와 “\\n” 문자 사이에 커스텀 구분자를 지정")
    void customSeparatorTest() {
        assertThat(StringAndCalculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생")
    void minusNumberTest() {
        assertThatThrownBy(() -> StringAndCalculator.splitAndSum("-1,2")).isInstanceOf(RuntimeException.class);
        assertThatThrownBy(() -> StringAndCalculator.splitAndSum("1,2,19.0")).isInstanceOf(RuntimeException.class);
    }
}
