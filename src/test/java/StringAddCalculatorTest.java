import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class StringAddCalculatorTest {
    @ParameterizedTest
    @EmptySource
    @NullSource
    @DisplayName("빈 문자열 또는 null이면 0을 반환")
    void whenGivenNullOrEmpty(String input) {
        String str = input;
        int result = -1;

        if (str == null || str.equals("")) {
            result = 0;
        }

        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("하나의 문자열로 입력할 경우 해당 숫자를 반환한다")
    void inputOneStringReturnToInteger() {
        String str = "1";
        int result = Integer.parseInt(str);
        Assertions.assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("숫자 두 개를 컴파(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다")
    void sumAndSplitWithComma() {
        String str = "1,2";
        String[] strs = str.split(",");
        int result = 0;
        for (String s : strs) {
            result += Integer.parseInt(s);
        }
        Assertions.assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("구분자를 컴마 이외에 콜론을 사용할 수 있다")
    void sumAndSplitWithCommaOrColon() {
        String str = "1,2:3";
        String[] strs = str.split(",|:");
        int result = 0;
        for (String s : strs) {
            result += Integer.parseInt(s);
        }
        Assertions.assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName(" \"//\" 와 \"\\n\" 문자 사이에 커스텀 구분자를 지정할 수 있다")
    void customDelimeter() {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher("//;\\n1;2;3");
        String[] tokens;
        int result = 0;
        if (m.find()) {
            String customDelimiter = m.group(1);
            tokens = m.group(2).split(customDelimiter);
            // 덧셈 구현
            for (String token : tokens) {
                result += Integer.parseInt(token);
            }
            Assertions.assertThat(result).isEqualTo(6);
        }
    }

    @Test
    @DisplayName("음수를 전달할 경우 RuntimeException")
    void negativeReturnRuntimeException() {
        String str = "-1,2,3";
        String[] strs = str.split(",");
        final int result = 0;
        for (String s : strs) {
            int num = Integer.parseInt(s);
            if (num < 0) {
                Assertions.assertThatThrownBy(() ->
                                StringAddCalculator.validNegative(num))
                        .isInstanceOf(RuntimeException.class);
            }
        }
    }
}
