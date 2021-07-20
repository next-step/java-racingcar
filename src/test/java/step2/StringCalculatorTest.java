package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("문자열 계산기 테스트")
class StringCalculatorTest {

    @ParameterizedTest(name = "{0}와 같은 문자열을 입력할 경우 실행 결과인 {1}을 출력해야 한다")
    @CsvSource(value = {
            "2 + 3 * 4 / 2, 10",
            "5 + 5 / 2 * 3, 15"
    })
    void calculate(String given, int expected) {
        final StringCalculator stringCalculator = new StringCalculator(given);
        final int actual = stringCalculator.calculate();

        assertThat(actual).isEqualTo(expected);
    }

}