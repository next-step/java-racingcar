package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class StringAddCalculatorTest {
    @Test
    void splitAndSum은_빈_문자열이나_공백문자인_경우_0을_반환한다() {
        assertThat(StringAddCalculator.splitAndSum(null)).isEqualTo(0);
        assertThat(StringAddCalculator.splitAndSum("")).isEqualTo(0);
    }

    @Test
    void splitAndSum은_숫자를_콤마_구분자로_입력할_경우_숫자의_합을_반환한다() {
        assertThat(StringAddCalculator.splitAndSum("1")).isEqualTo(1);
        assertThat(StringAddCalculator.splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    void splitAndSum은_구분자를_콤마_외에_콜론을_사용할_수_있다() {
        assertThat(StringAddCalculator.splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    void splitAndSum은_커스텀_구분자를_지정할_수_있다() {
        assertThat(StringAddCalculator.splitAndSum("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    void splitAndSum은_음수를_입력받은_경우_런타임_예외를_발생시킨다() {
        assertThatThrownBy(() -> {
            StringAddCalculator.splitAndSum("1;-2;3");
        }).isInstanceOf(RuntimeException.class);
    }
}
