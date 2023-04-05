import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {
    private static final StringCalculator stringCalculator = new StringCalculator();

    @DisplayName("쉼표(,) 또는 콜론(:)을 구분자로 가지는 문자열을 전달하는 경우, 구분자를 기준으로 분리한 각 숫자의 합을 반환한다.")
    @Test
    void calculate() {
        String str = "1,2;3";
        assertThat(stringCalculator.calculate(str))
            .isEqualTo(6);
    }

    @DisplayName("기본 구분자 외에 커스텀 구분자를 지정할 수 있다. 커스텀 구분자는 문자열 앞부분의 \"//\"와 \"\\n\" 사이에 위치하는 문자를 커스텀 구분자로 사용한다.")
    @Test
    void customDelimiter() {
        String str = "//.\n1.23.4";
        assertThat(stringCalculator.calculate(str))
            .isEqualTo(28);
    }

    @DisplayName("문자열 계산기에 숫자 이외의 값 또는 음수를 전달하는 경우 RuntimeException 예외를 던진다.")
    @Test
    void calculator_exception() {
        String str = "-1,2;3";
        assertThatThrownBy(() -> stringCalculator.calculate(str))
            .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("정규식 테스트")
    @Test
    void regex_test() {
        String input = "//;\n1;-2.3";
        String pattern = "//(.)\n(.+)";
        Pattern compiledPattern = Pattern.compile(pattern);
        Matcher matcher = compiledPattern.matcher(input);
        if (matcher.find()) {
            assertThat(matcher.group(1)).isEqualTo(";");
            assertThat(matcher.group(2)).isEqualTo("1;-2.3");
        }
    }
}