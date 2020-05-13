package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class StringCalculatorTest {

    @DisplayName("정상적인 입력으로 계산이 되는지 확인하는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1 + 2 + 3:6" , "1 + 2 / 3:1", "3 - 4:-1"}, delimiter = ':')
    void calculate(String formula, float calculatedValue) {
        Float result = new StringCalculator(formula).calculate();

        assertThat(result).isEqualTo(calculatedValue);
    }

    @DisplayName("null 또는 빈 입력이 들어왔을 때 IllegalArgumentException 발생 여부 테스트")
    @ParameterizedTest
    @NullAndEmptySource
    void calculateNullAndEmptyTest(String formula) {
        Throwable throwable = catchThrowable(() -> {
            Float result = new StringCalculator(formula).calculate();
        });

        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("지원하지 않는 Operator 입력시  IllegalArgumentException 발생 여부 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1 & 2 + 3:6" , "1 ! 2 / 3:1", "3 % 4:-1"}, delimiter = ':')
    void calculateNotOperatorSymbolTest(String formula, float calculatedValue) {
        Throwable throwable = catchThrowable(() -> {
            Float result = new StringCalculator(formula).calculate();
        });

        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("잘못된 입력 문자열에 대한 IllegalArgumentException 발생 여부 테스트")
    @ParameterizedTest
    @CsvSource({"1 + 2 + - 1", "2 - 2 +", "2+3/4", "- 2 + 1"})
    void calculateWrongFormula(String formula) {

        Throwable throwable = catchThrowable(() -> {
            StringCalculator stringCalculator = new StringCalculator(formula);
            Float result = stringCalculator.calculate();
        });

        assertThat(throwable).isInstanceOf(IllegalArgumentException.class);
    }
}