package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddPositiveCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("요구사항 1. 빈 문자열 또는 null 값을 입력할 경우 0을 반환")
    void splitAndSum_nullOrEmpty(String input) {
        Positive result = StringAddPositiveCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(new Positive(0));
    }

    @ParameterizedTest
    @ValueSource(strings = "1")
    @DisplayName("요구사항 2. 숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환")
    void splitAndSum_singleNumber(String input) {
        Positive result = StringAddPositiveCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(new Positive(1));
    }

    @ParameterizedTest
    @ValueSource(strings = "1,2")
    @DisplayName("요구사항 3. 숫자 두개를 ','구분자로 입력할 경우 두 숫자의 합을 반환")
    void splitAndSum_commaDelimiter(String input) {
        Positive result = StringAddPositiveCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(new Positive(3));
    }

    @ParameterizedTest
    @ValueSource(strings = "1,2:3")
    @DisplayName("요구사항 4. 구분자를 컴마 ','이외에 ':'콜론을 사용할 수 있다.")
    void splitAndSum_commaOrColonDelimiter(String input) {
        Positive result = StringAddPositiveCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(new Positive(6));
    }

    @ParameterizedTest
    @ValueSource(strings = "//;\n1;2;3")
    @DisplayName("요구사항 5. '//', '\n' 문자 사이에 커스텀 구분자를 지정")
    void splitAndSum_customDelimiter(String input) {
        Positive result = StringAddPositiveCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(new Positive(6));
    }

    @ParameterizedTest
    @ValueSource(strings = "a,-1,2,3")
    @DisplayName("요구사항 6. 음수를 전달할 경우 RuntimeException 예외가 발생")
    void splitAndSum_negative(String input) {
        assertThatThrownBy(() -> StringAddPositiveCalculator.splitAndSum(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}