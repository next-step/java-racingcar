package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import stringcalculator.utils.Util;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {

    @DisplayName("빈 배열의 덧셈 계산 결과는 0이다")
    @Test
    void 덧셈_계산_빈_배열() {
        String[] nums = {};
        int result = Util.sumString(nums);
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("하나의 값만 있는 배열의 덧셈 계산은 해당 값이다")
    @Test
    void 덧셈_계산_하나() {
        String[] nums = {"7"};
        int result = Util.sumString(nums);
        assertThat(result).isEqualTo(7);
    }
    @DisplayName("둘 이상의 덧셈 계산이 올바르게 수행되어야 한다")
    @Test
    void 덧셈_계산_둘_이상() {
        String[] nums = {"1", "4", "10"};
        int result = Util.sumString(nums);
        assertThat(result).isEqualTo(15);
    }

    @DisplayName("커스텀 구분자가 있는 경우 제대로 분리된다")
    @Test
    void 커스텀_구분자_분리() {
        String input = "1;2;3";
        String delimiter = ";";

        StringExpression stringExpression = new StringExpression(input, delimiter);

        assertThat(stringExpression.getStringArray()).containsExactly("1", "2", "3");
    }

    @DisplayName("일반 구분자의 경우 제대로 분리된다")
    @Test
    void 일반_구분자_분리() {
        String input = "1:2,3";
        String delimiter = ",|:";

        StringExpression stringExpression = new StringExpression(input, delimiter);

        assertThat(stringExpression.getStringArray()).containsExactly("1", "2", "3");

    }

    @DisplayName("양수로만 이루어진 경우 예외가 발생하지 않는다")
    @Test
    void 문자열_검증_성공() {
        String input = "1;2;3";
        String delimiter = ";";

        assertThatNoException().isThrownBy(() -> new StringExpression(input, delimiter));
    }


    @DisplayName("음수가 존재하는 경우 RuntimeException 예외가 발생한다")
    @Test
    void 문자열_검증_실패_음수() {
        String input = "1;-2;3";
        String delimiter = ";";

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> new StringExpression(input, delimiter))
                .withMessageMatching("유효하지 않은 값입니다");
    }

    @DisplayName("숫자 이외의 값이 존재하는 경우 RuntimeException 예외가 발생한다")
    @Test
    void 문자열_검증_실패_숫자외의_값() {
        String input = "1:4-5,6";
        String delimiter = ":|,";

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> new StringExpression(input, delimiter))
                .withMessageMatching("유효하지 않은 값입니다");
    }


    @DisplayName("기본 구분자가 주어졌을 때 올바른 계산 결과를 반환한다")
    @Test
    void 기본_구분자_계산() {
        String input = "4:8,11";

        int result = StringCalculatorRunner.run(input);

        assertThat(result).isEqualTo(23);
    }

    @DisplayName("문자열이 주어졌을 때 올바른 계산 결과를 반환한다")
    @Test
    void 커스텀_구분자_계산() {
        String input = "//;\n1;4;9";

        int result = StringCalculatorRunner.run(input);

        assertThat(result).isEqualTo(14);
    }
}