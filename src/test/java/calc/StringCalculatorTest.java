package calc;

import org.assertj.core.util.Strings;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    @Test
    @DisplayName("양수만 있는 문자열 계산 테스트")
    public void 양수만_있는_문자열_계산_테스트() {

        // given
        final String expression = "1";

        // when
        int result = StringCalculator.calculate(expression);

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("음수만 있는 문자열 계산 테스트")
    public void 음수만_있는_문자열_계산_테스트() {

        // given
        final String expression = "-1";

        // when
        int result = StringCalculator.calculate(expression);

        // then
        assertThat(result).isEqualTo(-1);
    }

    @Test
    @DisplayName("부호가 1개 있는 문자열 계산 테스트")
    public void 부호가_1개_있는_문자열_계산_테스트() {

        // given
        final String expression = "1 + 2";

        // when
        int result = StringCalculator.calculate(expression);

        // then
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("부호가 여러 개 있는 문자열 계산 테스트")
    public void 부호가_여러_개_있는_문자열_계산_테스트() {

        // given
        final String expression = "1 + 2 - 3 * 4 / 5";

        // when
        int result = StringCalculator.calculate(expression);

        // then
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("처음 숫자가 음수이고 부호가 여러 개 있는 문자열 계산 테스트")
    public void 처음_숫자가_음수이고_부호가_여러_개_있는_문자열_계산_테스트() {

        // given
        final String expression = "- 1 + 2 - 3 * 4 / 5";

        // when
        int result = StringCalculator.calculate(expression);

        // then
        assertThat(result).isEqualTo(-1);
    }

    @Test
    @DisplayName("잘못된 형식의 식 예외 처리 테스트")
    public void 잘못된_형식의_식_예외_처리_테스트() {
        // given
        final String expression = "- 1 + 2 - 3 * 4 / 5 -";

        // when, then
        assertThatThrownBy(() -> StringCalculator.calculate(expression))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("invalid expression");
    }

    @Test
    @DisplayName("빈 값 예외 처리 테스트")
    public void 빈_값_예외_처리_테스트() {
        // given
        final String expression = " ";

        // when, then
        assertThatThrownBy(() -> StringCalculator.calculate(expression))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("invalid expression");
    }

    @Test
    @DisplayName("null 값 예외 처리 테스트")
    public void null_값_예외_처리_테스트() {
        // given
        final String expression = null;

        // when, then
        assertThatThrownBy(() -> StringCalculator.calculate(expression))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessageMatching("expression must not be null");
    }
}
