package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorTest {

    @ParameterizedTest
    @NullSource
    @ValueSource(strings = {""})
    @DisplayName("요구사항 1. 빈 문자열 또는 null 값을 입력할 경우 0을 반환")
    void splitAndSum_nullOrEmpty(String input) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isZero();
    }

    @Test
    @DisplayName("요구사항 2. 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환")
    void splitAndSum_singleNumber() {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("요구사항 3. 숫자 두개를 ','구분자로 입력할 경우 두 숫자의 합을 반환")
    void splitAndSum_commaDelimiter() {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("요구사항 4. 구분자를 컴마 ','이외에 ':'콜론을 사용할 수 있다.")
    void splitAndSum_commaOrColonDelimiter() {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("요구사항 5. '//', '\n' 문자 사이에 커스텀 구분자를 지정")
    void splitAndSum_customDelimiter() {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("요구사항 6. 음수를 전달할 경우 RuntimeException 예외가 발생")
    void splitAndSum_negative() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("a,-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}