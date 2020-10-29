package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @BeforeEach
    void setup() {
        stringCalculator = new StringCalculator();
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3:5", "7 - 4:3", "8 * 3:24", "8 / 2:4"}, delimiter = ':')
    @DisplayName("간단한 문자열 사칙연산 테스트")
    public void simpleCalculateTest(String input, Integer resultValue) {
        Integer result = stringCalculator.calculate(input);
        assertThat(result).isEqualTo(resultValue);
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10"}, delimiter = ':')
    @DisplayName("복합 문자열 사칙 연산 계산기 구현 및 테스트")
    public void compositeCalculateTest(String input, Integer resultValue) {
        Integer result = stringCalculator.calculate(input);
        assertThat(result).isEqualTo(resultValue);
    }

    //":입력", " :입력", "2 +3:사칙연산",
    @ParameterizedTest
    @CsvSource(value = {":입력", " :입력", "2 +3:사칙연산"}, delimiter = ':')
    @DisplayName("사칙연산 예외 테스트")
    public void calculateExceptionTest(String input, String message) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> {
                    stringCalculator.calculate(input);
                })
                .withMessageStartingWith(message);
    }

}
