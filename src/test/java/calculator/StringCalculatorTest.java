package calculator;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

@DisplayName("사칙 연산 문자열 계산기 테스트")
class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "2 + 3 * 4 / 2 + 2:12"}, delimiter = ':')
    @DisplayName("right test")
    void rightTest(String input, int expect) {
        assertThat(StringCalculator.calculate(input)).isEqualTo(expect);
    }

    @ParameterizedTest
    @ValueSource(strings = {"",
                            " ",
                            "3",
                            "3 3",
                            "-",
                            "- -",
                            "3 - 4 =",
                            "4 - 4 - - -"})
    @DisplayName("error test")
    void errorTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.calculate(input);
        });
    }

}