package calc;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    private final StringAddCalculator stringAddCalculator = new StringAddCalculator();

    @Test
    void 숫자하나() {
        assertThat(stringAddCalculator.splitAndSum("1")).isEqualTo(1);
    }

    @Test
    void 쉼표가_포함() {
        assertThat(stringAddCalculator.splitAndSum("1,2")).isEqualTo(3);
    }

    @Test
    void 콜론_포함() {
        assertThat(stringAddCalculator.splitAndSum("1,2:3")).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자_지정() {
        int result = stringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 음수인_경우() {
        assertThatThrownBy(() -> {
            stringAddCalculator.splitAndSum("3,-1");
        }).isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 빈값(String input) {
        assertThat(stringAddCalculator.splitAndSum(input)).isEqualTo(0);
    }
}
