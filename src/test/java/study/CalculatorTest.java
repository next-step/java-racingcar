package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CalculatorTest {

    static Stream<String> errorCaseStrings() {
        return Stream.of(null, "", " ", "3 +", "3 + a");
    }

    @ParameterizedTest
    @MethodSource("errorCaseStrings")
    @DisplayName("입력 값이 유효하지 않을 경우 테스트")
    void validation(String formula) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            float result = new FormulaCalculator(formula).getResult();
            System.out.println(result);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {"3 + 2=5", "2 + 3 * 4 / 2=10", "2 * 3 + 8 / 7 * 4 - 1=7"}, delimiter = '=')
    @DisplayName("입력 값이 유효할 경우 테스트")
    void calc(String formula, float expected) {
        assertThat(new FormulaCalculator(formula).getResult()).isEqualTo(expected);
    }
}
