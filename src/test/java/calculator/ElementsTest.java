package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ElementsTest {

    @ParameterizedTest(name = "{displayName} [{index}] {0} ")
    @ValueSource(strings = {"2 + 3 * 4 / 2"})
    @DisplayName("공백 단위로 문자열을 분리한다.")
    void splitWithSpace(String input) {
        Elements result = new Elements(input);
        assertThat(result).isEqualTo(new Elements("2 + 3 * 4 / 2"));
    }

    @ParameterizedTest(name = "{displayName} [{index}] {0} ")
    @NullAndEmptySource
    @DisplayName("입력값이 null 이거나 빈 공백일 경우 에러가 발생한다.")
    void checkInputIsNullOrEmpty(String input) {
        assertThatThrownBy(() -> new Elements(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{displayName} [{index}] {0} ")
    @ValueSource(strings = {"+ + 3 * 4 / 2"})
    @DisplayName("홀수번째 문자 숫자가 아닌 경우 에러가 발생한다.")
    void checkOnlyNumberAtOddIndex(String input) {
        assertThatThrownBy(() -> new Elements(input).calculate())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{displayName} [{index}] {0} ")
    @ValueSource(strings = {"1 2 3 * 4 / 2"})
    @DisplayName("짝수번째 문자 연산자가 아닌 경우 에러가 발생한다.")
    void checkOnlyOperatorAtEvenIndex(String input) {
        assertThatThrownBy(() -> new Elements(input).calculate())
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest(name = "{displayName} [{index}] {0} ")
    @ValueSource(strings = {"2 + 3 * 4 / 2"})
    @DisplayName("문자열 사칙연산 계산")
    void calc(String input) {
        int result = new Elements(input).calculate();
        assertThat(result).isEqualTo(10);
    }
}
