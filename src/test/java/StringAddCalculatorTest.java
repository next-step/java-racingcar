import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    void null_Empty(String input) {
        assertThat(StringAddCalculator.calculate(input)).isEqualTo(0);
    }

    @Test
    void 숫자하나() {
        assertThat(StringAddCalculator.calculate("3")).isEqualTo(3);
    }

    @Test
    void 쉼표_콜론_구분자() {
        assertThat(StringAddCalculator.calculate("1,2:3")).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자() {
        assertThat(StringAddCalculator.calculate("//;\n1;2;3;4")).isEqualTo(10);
    }

    @Test
    void 음수() {
        assertThatThrownBy(() -> StringAddCalculator.calculate("1,-2,3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Negative Value");
    }

    @Test
    void 숫자이외의값() {
        assertThatThrownBy(() -> StringAddCalculator.calculate("!,2,3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("Non-Numeric Value");
    }

}
