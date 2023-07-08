package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {

    @DisplayName("빈 문자열의 덧셈 계산 결과는 0이다")
    @Test
    void 덧셈_계산_빈_문자열() {
        String text = "";

        StringCalculator stringCalculator = new StringCalculator(text);

        assertThat(stringCalculator.calculate()).isEqualTo(0);
    }

    @DisplayName("null의 덧셈 계산 결과는 0이다")
    @Test
    void 덧셈_계산_널() {
        String text = null;

        StringCalculator stringCalculator = new StringCalculator(text);

        assertThat(stringCalculator.calculate()).isEqualTo(0);
    }

    @DisplayName("하나의 값만 있는 문자열의 덧셈 계산은 해당 값이다")
    @Test
    void 덧셈_계산_하나() {
        String text = "7";

        StringCalculator stringCalculator = new StringCalculator(text);

        assertThat(stringCalculator.calculate()).isEqualTo(7);
    }

    @DisplayName("둘 이상의 덧셈 계산이 올바르게 수행되어야 한다")
    @Test
    void 덧셈_계산_둘_이상() {
        String text = "1,4:10";

        StringCalculator stringCalculator = new StringCalculator(text);

        assertThat(stringCalculator.calculate()).isEqualTo(15);
    }

    @DisplayName("양수로만 이루어진 경우 예외가 발생하지 않는다")
    @Test
    void 문자열_검증_성공() {
        String[] elements = {"1", "2", "3"};

        assertThatNoException().isThrownBy(() -> new Elements(elements));
    }

    @DisplayName("음수가 존재하는 경우 RuntimeException 예외가 발생한다")
    @Test
    void 문자열_검증_실패_음수() {
        String[] elements = {"1", "-2", "3"};

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> new Elements(elements))
                .withMessageMatching("0이상 9이하의 숫자만 가능합니다");
    }

    @DisplayName("숫자 이외의 값이 존재하는 경우 RuntimeException 예외가 발생한다")
    @Test
    void 문자열_검증_실패_숫자외의_값() {
        String[] elements = {"1", "4", "-5", "6"};

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> new Elements(elements))
                .withMessageMatching("0이상 9이하의 숫자만 가능합니다");
    }

    @DisplayName("기본 구분자가 주어졌을 때 올바른 계산 결과를 반환한다")
    @Test
    void 기본_구분자_계산() {
        String text = "4:8,11";

        StringCalculator stringCalculator = new StringCalculator(text);
        int result = stringCalculator.calculate();

        assertThat(result).isEqualTo(23);
    }

    @DisplayName("문자열이 주어졌을 때 올바른 계산 결과를 반환한다")
    @Test
    void 커스텀_구분자_계산() {
        String text = "//;\n1;4;9";

        StringCalculator stringCalculator = new StringCalculator(text);
        int result = stringCalculator.calculate();

        assertThat(result).isEqualTo(14);
    }
}
