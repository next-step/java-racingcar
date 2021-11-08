package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CalculatorTest {

    @Test
    @DisplayName("입력 값이 null이거나 빈 공백 문자열인 경우 IllegalArgumentException 발생")
    void executeWithNullArgument() {
        assertThatIllegalArgumentException().isThrownBy(() -> Calculator.execute(InputString.from("")));
        assertThatIllegalArgumentException().isThrownBy(() -> Calculator.execute(InputString.from(null)));

    }

    @DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException 발생")
    @ParameterizedTest
    @ValueSource(strings = {"+ 2", "2 $ 3", "2 2", "2 + 3 -"})
    void executeWithWrongArgument(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> Calculator.execute(InputString.from(input)));

    }

    @DisplayName("사칙연산 계산 성공")
    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "2:2"}, delimiter = ':')
    void execute(String input, int result) {
        System.out.println(Calculator.execute(InputString.from(input)));
        assertThat(Calculator.execute(InputString.from(input))).isEqualTo(result);
    }


}