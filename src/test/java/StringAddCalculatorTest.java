import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
    @Test
    @DisplayName("null_또는_빈문자가_입력으로_들어오면_무조건_0_리턴")
    public void nullOrBlankTest() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum(" ");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("숫자_하나가_입력으로_들어와도_정상적으로_숫자합이_계산된다")
    void singleNumTest() {
        final int actual = StringAddCalculator.splitAndSum("1");
        assertThat(actual).isEqualTo(1);
    }

    @Test
    @DisplayName("컴마 구분자가 포함된 문자열을 입력으로 받았을 때 정상동작한다")
    void commaTest() {
        assertThat(StringAddCalculator.splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    @DisplayName("콜론 구분자가 포함된 문자열을 입력으로 받았을 때 정상동작한다")
    void colonsTest() {
        assertThat(StringAddCalculator.splitAndSum("1:2")).isEqualTo(3);
    }

    @Test
    @DisplayName("컴마와 콜론 구분자가 포함된 문자열을 입력으로 받았을 때 정상동작한다")
    void commaColonsTest() {
        assertThat(StringAddCalculator.splitAndSum("1:2,3")).isEqualTo(6);
    }

    @Test
    @DisplayName("커스텀 구분자가 포함된 문자열을 입력으로 받았을 때 정상동작한다")
    void customDelimiter() {
        assertThat(StringAddCalculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    @DisplayName("음수가 포함된 문자열을 입력으로 받았을 때 RuntimeException이 발생한다")
    public void splitAndSum_negative() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}
