package calculator;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("StringCalculator 테스트 클래스")
class StringCalculatorTest {

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "2 + 3 * 4 / 2 + 2:12"}, delimiter = ':')
    @DisplayName("calculate 정상 테스트")
    void calculateTest(String input, int expect) {
        assertThat(StringCalculator.calculate(input)).isEqualTo(expect);
    }

    @ParameterizedTest
    @ValueSource(strings = {" ","- -","3 3","- 4 * 4","- 4 -"})
    @DisplayName("calculate 잘못된 입력값 테스트")
    void calculateFaultInputTest(String input) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            StringCalculator.calculate(input);
        });
    }

}