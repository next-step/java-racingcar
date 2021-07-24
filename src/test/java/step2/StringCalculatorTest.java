package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringCalculatorTest {

    @DisplayName("4칙 연산 테스트")
    @ParameterizedTest(name = "{index} {displayName} argument: {arguments}")
    @CsvSource(value = {"2 + 3,5", "5 - 2,3", "3 * 6,18", "4 / 2,2"}, delimiter = ',')
    void simple_calculate(String formulas, int expected) {
        int result = StringCalculator.calculate(new Formulas(formulas));
        assertThat(result).isEqualTo(expected);
    }

    @DisplayName("복합 계산 테스트")
    @Test
    void complex_calculate() {
        int result = StringCalculator.calculate(new Formulas("2 + 3 * 4 / 2"));
        assertThat(result).isEqualTo(10);
    }

    @DisplayName("4칙 연산자가 아닌 값이 입력 될 경우 IllegalArgumentException 발생")
    @ParameterizedTest(name = "{index} {displayName} argument: {arguments}")
    @ValueSource(strings = {"2 + 3 @ 4 - 2", "2 6 7 - 3"})
    void calculate_throwsIllegalArgumentException_IfOperatorIsNot4Rules(String formulas) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> StringCalculator.calculate(new Formulas(formulas))
        );
    }

    @DisplayName("숫자가 아닌 값이 입력 될 경우 IllegalArgumentException 발생")
    @ParameterizedTest(name = "{index} {displayName} argument: {arguments}")
    @ValueSource(strings = {"% + 3 * 4 / 2", "  + 7 - 3"})
    void calculate_throwsIllegalArgumentException_IfOperandIsNotNumber(String formulas) {
        assertThatIllegalArgumentException().isThrownBy(
                () -> StringCalculator.calculate(new Formulas(formulas))
        );
    }
}
