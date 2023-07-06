package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StringCalculatorTest {

    @DisplayName("빈 문자열의 덧셈 계산 결과는 0이다")
    @Test
    void 덧셈_계산_빈_문자열() {
        Expression stringExpression = ExpressionFactory.create("");

        int result = stringExpression.sumString();

        assertThat(result).isEqualTo(0);
    }

    @DisplayName("null의 덧셈 계산 결과는 0이다")
    @Test
    void 덧셈_계산_널() {
        Expression stringExpression = ExpressionFactory.create(null);

        int result = stringExpression.sumString();

        assertThat(result).isEqualTo(0);
    }

    @DisplayName("하나의 값만 있는 문자열의 덧셈 계산은 해당 값이다")
    @Test
    void 덧셈_계산_하나() {
        Expression stringExpression = ExpressionFactory.create("7");

        int result = stringExpression.sumString();

        assertThat(result).isEqualTo(7);
    }

    @DisplayName("둘 이상의 덧셈 계산이 올바르게 수행되어야 한다")
    @Test
    void 덧셈_계산_둘_이상() {
        Expression stringExpression = ExpressionFactory.create("1,4:10");

        int result = stringExpression.sumString();

        assertThat(result).isEqualTo(15);
    }

    @DisplayName("양수로만 이루어진 경우 예외가 발생하지 않는다")
    @Test
    void 문자열_검증_성공() {
        String input = "1;2;3";
        String delimiter = ";";

        assertThatNoException().isThrownBy(() -> new Expression(input, delimiter));
    }

    @DisplayName("음수가 존재하는 경우 RuntimeException 예외가 발생한다")
    @Test
    void 문자열_검증_실패_음수() {
        String input = "1;-2;3";
        String delimiter = ";";

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> new Expression(input, delimiter))
                .withMessageMatching("유효하지 않은 값입니다");
    }

    @DisplayName("숫자 이외의 값이 존재하는 경우 RuntimeException 예외가 발생한다")
    @Test
    void 문자열_검증_실패_숫자외의_값() {
        String input = "1:4-5,6";
        String delimiter = ":|,";

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> new Expression(input, delimiter))
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
