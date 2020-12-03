package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("문자열 계산기(StringCalculator) 테스트")
class StringCalculatorTest {

    @DisplayName("판독기(Reader) 를 가지는 문자열 계산기(StringCalculator)를 생성한다.")
    @Test
    void create() {
        // given
        Reader reader = new Reader(" ");

        // when
        StringCalculator stringCalculator = new StringCalculator(reader);

        // then
        assertThat(stringCalculator).isNotNull();
    }

    @DisplayName("문자열을 판독하고 계산할 수 있다.")
    @ParameterizedTest
    @CsvSource({
            "1 + 3,4",
            "1 + 2 - 4 / 2 * 10,0",
            "3 + 14 - 2 / 5 * 3,9",
            "2 + 3 * 4 / 2,10"})
    void calculate(String value, int expected) {
        // given
        Reader reader = new Reader(" ");

        // when
        StringCalculator stringCalculator = new StringCalculator(reader);
        int calculate = stringCalculator.calculate(value);

        // when / then
        assertThat(calculate).isEqualTo(expected);
    }
}
