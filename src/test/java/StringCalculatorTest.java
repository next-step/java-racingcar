import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTest {
    @DisplayName("빈 문자열을 혹은 null 값을 입력할 경우 0을 반환해야한다")
    @ParameterizedTest
    @NullAndEmptySource
    public void nullOrEmptyString(String input) {
        assertThat(StringCalculator.calculate(input)).isEqualTo(0);
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 숫자를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"123:123", "1:1"}, delimiter = ':')
    public void numberString(String input, int expected) {
        assertThat(StringCalculator.calculate(input)).isEqualTo(expected);
    }

    @DisplayName("숫자 두개를 컴마로 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    @ParameterizedTest
    @CsvSource(value={"1,2,3|6", "4,5,6,7|22"}, delimiter = '|')
    public void numberStringWithComma(String input, int expected) {
        assertThat(StringCalculator.calculate(input)).isEqualTo(expected);
    }

    @DisplayName("숫자 두개를 콜론을 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
    @ParameterizedTest
    @CsvSource(value={"1:2:3|6", "4:5:6:7|22"}, delimiter = '|')
    public void numberStringWithColon(String input, int expected) {
        assertThat(StringCalculator.calculate(input)).isEqualTo(expected);
    }

    @DisplayName("//와 \\n 문자 사이에 커스텀 구분자를 지정할 수 있다")
    @ParameterizedTest
    @MethodSource("provideCustomDelimiterCases")
    public void numberStringWithCustomDelimiter(String input, int expected) {
        assertThat(StringCalculator.calculate(input)).isEqualTo(expected);
    }

    static Stream<Arguments> provideCustomDelimiterCases() {
        return Stream.of(
                Arguments.of("//;\n1;2;3", 6),
                Arguments.of("//~\n1~2~3", 6)
        );
    }

    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생해야 한다.")
    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringCalculator.calculate("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
