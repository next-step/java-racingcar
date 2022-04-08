package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
    @Test
    void 빈_문자열이거나_Null일_경우() {
        Assertions.assertThat(StringAddCalculator.splitAndSum(null)).isEqualTo(0);
        Assertions.assertThat(StringAddCalculator.splitAndSum("")).isEqualTo(0);
    }

    @Test
    void 빈_문자_Null이_아닌_경우() {
        Assertions.assertThat(StringAddCalculator.splitAndSum("1,2")).isEqualTo(3);
        Assertions.assertThat(StringAddCalculator.splitAndSum("1,2,3")).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자를_지정한_경우() {
        Assertions.assertThat(StringAddCalculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    void 숫자_이외의_값_또는_음수를_전달하는_경우_예외를_던진다() {
        Assertions.assertThatThrownBy(() -> {
            StringAddCalculator.splitAndSum("-1,2,3");
        }).isInstanceOf(RuntimeException.class);

        Assertions.assertThatThrownBy(() -> {
            StringAddCalculator.splitAndSum("k,2,3");
        }).isInstanceOf(RuntimeException.class);


    }
}
