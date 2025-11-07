package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class StringCalculatorTest {

    private final StringCalculator calculator = new StringCalculator();

    @ParameterizedTest
    @NullAndEmptySource
    public void 입력값이_NULL_이거나_빈문자열인_경우_0을_리턴할_수_있다(String input) {
        assertThat(
                calculator.splitAndSum(input)
        ).isEqualTo(0);
    }

    @Test
    public void 입력값으로_숫자하나만_입력된_경우_해당값을_리턴할_수_있다() {
        assertThat(
                calculator.splitAndSum("1")
        ).isEqualTo(1);
    }

    @Test
    public void 입력값의_구분자가_쉼표인_경우_숫자들의_합을_계산할_수_있다() {
        assertThat(
                calculator.splitAndSum("1,2")
        ).isEqualTo(3);
    }

    @Test
    public void 입력값의_구분자가_쉼표와_콜론인_경우_숫자들의_합을_계산할_수_있다() {
        assertThat(
                calculator.splitAndSum("1,2:3")
        ).isEqualTo(6);
    }

    @Test
    public void 입력값의_구분자가_커스텀인_경우_숫자들의_합을_계산할_수_있다() {
        assertThat(
                calculator.splitAndSum("//;\n1;2;3")
        ).isEqualTo(6);
    }

    @Test
    public void 입력값의_숫자가_음수인_경우_예외처리를_할_수_있다() {
        assertThatThrownBy(
                () -> calculator.splitAndSum("-1,2,3")
        ).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void 입력값의_숫자가_문자인_경우_예외처리를_할_수_있다() {
        assertThatThrownBy(
                () -> calculator.splitAndSum("1,ㅁ,3")
        ).isInstanceOf(RuntimeException.class);
    }

}
