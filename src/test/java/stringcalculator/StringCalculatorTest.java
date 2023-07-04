package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

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

    @DisplayName("양수로만 이루어진 경우 예외가 발생하지 않는다")
    @Test
    void 문자열_검증_성공() {
        String[] stringArray = {"1", "2", "3"};

        assertThatNoException().isThrownBy(() -> StringCalculator.checkValidArray(stringArray));
    }


    @DisplayName("음수가 존재하는 경우 RuntimeException 예외가 발생한다")
    @Test
    void 문자열_검증_실패_음수() {
        String[] stringArray = {"-1", "2", "3"};

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> StringCalculator.checkValidArray(stringArray))
                .withMessageMatching("유효하지 않은 값입니다");
    }

    @DisplayName("숫자 이외의 값이 존재하는 경우 RuntimeException 예외가 발생한다")
    @Test
    void 문자열_검증_실패_숫자외의_값() {
        String[] stringArray = {"1", "2%", ";3;"};

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> StringCalculator.checkValidArray(stringArray))
                .withMessageMatching("유효하지 않은 값입니다");

    }

    @DisplayName("커스텀 구분자면 true를 반환한다")
    @Test
    void 커스텀_구분자인_경우() {
        String input = "//;\n1;2;3";

        boolean result = StringCalculator.isCustomDelimiter(input);

        assertThat(result).isEqualTo(true);
    }

    @DisplayName("커스텀 구분자가 아니면 false를 반환한다")
    @Test
    void 커스텀_구분자가_아닌경우() {
        String input = "1;2;3";

        boolean result = StringCalculator.isCustomDelimiter(input);

        assertThat(result).isEqualTo(false);
    }

    @DisplayName("문자열이 주어졌을 때 올바른 계산 결과를 반환한다")
    @Test
    void 주어진_문자열_계산() {
        String input1 = "4:8,11";
        String input2 = "//;\n1;4;9";

        int result1 = StringCalculator.run(input1);
        int result2 = StringCalculator.run(input2);

        assertThat(result1).isEqualTo(23);
        assertThat(result2).isEqualTo(14);
    }
}