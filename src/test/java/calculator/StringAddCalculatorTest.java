package calculator;

import exception.NegativeException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringAddCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 빈_문자열이거나_null일_경우_0으로_반환(String input) {
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "3", "5", "9"})
    void 숫자_하나를_문자열로_입력할_경우_해당_숫자_반환(String input) {
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1:2,3", "3:2:1", "1,3:2"})
    void 구분자를_콤마_혹은_콜론으로_사용(String input) {
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//:\n1:2:3", "//!\n1!2!3", "//@\n3@2@1", "//a\n1a3a2"})
    void 커스텀_구분자_사용(String input) {
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1,2,5", "1,-5,6", "1:3,-8", "-1:-2:-8"})
    void 음수를_전달할_경우_RuntimeException_발생(String input) {
        assertThrows(NegativeException.class, () -> StringAddCalculator.splitAndSum(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"//:\n1:-2:3", "//!\n-1!2!3", "//@\n3@2@-1", "//a\n-1a-3a-2"})
    void 음수를_전달할_경우_커스텀_구분자_일경우(String input) {
        assertThrows(NegativeException.class, () -> StringAddCalculator.splitAndSum(input));
    }
}
