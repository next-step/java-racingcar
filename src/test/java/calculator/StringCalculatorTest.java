package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class StringCalculatorTest {


    @ParameterizedTest
    @DisplayName("calulate 테스트")
    @CsvSource(value = {"1 + 5 - 4 * 2 / 2=2", "4 - 1 * 2 / 3 + 1=3"}, delimiter = '=')
    void 통합_계산_테스트(String input, Number expectedResult) {
        Number result = StringCalculator.calculate(input);

        assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @DisplayName("calulate 테스트: input이 null이거나 빈 문자열인 경우 IllegalArgumentException이 발생한다.")
    @NullAndEmptySource
    void 널값과_빈_문자열_테스트(String input) {
        assertThatIllegalArgumentException().isThrownBy(() ->
            StringCalculator.calculate(input)
        );
    }

    @ParameterizedTest
    @DisplayName("calulate 테스트: 0으로 나누는 경우 IllegalArgumentException이 발생한다. ")
    @ValueSource(strings = {"1 + 5 - 4 * 2 / 0", "5 / 0"})
    void 영으로_나눌경우_테스트(String input) {
        assertThatIllegalArgumentException().isThrownBy(() ->
            StringCalculator.calculate(input)
        );
    }

}
