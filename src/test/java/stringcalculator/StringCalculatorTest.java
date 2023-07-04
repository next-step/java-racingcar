package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {

    @DisplayName("빈 배열의 덧셈 계산 결과는 0이다")
    @Test
    void 덧셈_계산_빈_배열() {
        int[] nums = {};
        int result = StringCalculator.sum(nums);
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("하나의 값만 있는 배열의 덧셈 계산은 해당 값이다")
    @Test
    void 덧셈_계산_하나() {
        int[] nums = {7};
        int result = StringCalculator.sum(nums);
        assertThat(result).isEqualTo(7);
    }
    @DisplayName("둘 이상의 덧셈 계산이 올바르게 수행되어야 한다")
    @Test
    void 덧셈_계산_둘_이상() {
        int[] nums = {1, 4, 10};
        int result = StringCalculator.sum(nums);
        assertThat(result).isEqualTo(15);
    }

    @DisplayName("문자열 배열을 정수 배열로 바꾼다")
    @Test
    void 문자열_변환() {
        String[] stringArray = new String[]{"1", "2", "3"};

        int[] result = StringCalculator.toIntArray(stringArray);

        assertThat(result).containsExactly(1, 2, 3);
    }

    @DisplayName("커스텀 구분자를 분리한다")
    @Test
    void 커스텀_구분자_분리() {
        String input = "//;\n1;2;3";
        ParseInfo parseInfo = StringCalculator.separateCustomText(input);

        assertThat(parseInfo.delimiter).isEqualTo(";");
        assertThat(parseInfo.text).isEqualTo("1;2;3");
    }

    @DisplayName("문자열을 하나의 구분자로 배열로 분리한다")
    @Test
    void 문자열_파싱_구분자_하나() {
        ParseInfo parseInfo = new ParseInfo(";", "1;2;3");

        String[] result = parseInfo.parse();

        assertThat(result).containsExactly("1", "2", "3");
    }

    @DisplayName("문자열을 두개의 구분자로 배열로 분리한다")
    @Test
    void 문자열_파싱_구분자_둘() {
        ParseInfo parseInfo = new ParseInfo(":|,", "1:2,3:10");

        String[] result = parseInfo.parse();

        assertThat(result).containsExactly("1", "2", "3", "10");
    }
}