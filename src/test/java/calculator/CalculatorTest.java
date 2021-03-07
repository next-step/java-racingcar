package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CalculatorTest {

    @ParameterizedTest
    @NullSource
    @EmptySource
    @DisplayName("입력값 검증테스트 - 빈 문자열")
    void validateInput_isEmpty(String input) {
        // given
        Calculator calculator = new Calculator();

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy( () -> calculator.calculate(input) )
                .withMessageMatching("수식을 입력해 주세요");
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 -", "-", "3"})
    @DisplayName("입력값 검증테스트 - 수식 길이검증 테스트")
    void validateInput_isValidateLength(String input) {
        // given
        Calculator calculator = new Calculator();

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy( () -> calculator.calculate(input) )
                .withMessageMatching("수식은 최소 2개의 수와 1개의 연산자로 구성되어야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 - 3 +", "1 - 5 + 7 8", "- + * /"})
    @DisplayName("입력값 검증테스트 - 수식의 인자수는 홀수개여야 함")
    void validateInput_isFormulaEven(String input) {
        // given
        Calculator calculator = new Calculator();

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy( () -> calculator.calculate(input) )
                .withMessageMatching("수식은 홀수개의 인자로 구성되어야 합니다. 다시 입력해 주세요");
    }

    @ParameterizedTest
    @ValueSource(strings = {"- 1 3 + 7", "2 + -", "3 - 2 + * 1 2"})
    @DisplayName("입력값 검증테스트 - 수식의 짝수번째 인자는 숫자여야 함")
    void validateInput_isEvenIndexValueNumeric(String input) {
        // given
        Calculator calculator = new Calculator();

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy( () -> calculator.calculate(input) )
                .withMessageMatching("수식의 짝수번째 인자는 숫자여야 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 2 - 3 7", "2 + 1 3 5"})
    @DisplayName("입력값 검증테스트 - 수식의 홀수번째 인자는 연산자여야 함")
    void validateInput_isOddIndexValueOperator(String input) {
        // given
        Calculator calculator = new Calculator();

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy( () -> calculator.calculate(input) )
                .withMessageMatching("수식의 홀수번째 인자는 연산자여야 합니다.");
    }

    @ParameterizedTest
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "2 * 8 - 4:12", "3 / 2 + 1:2"}, delimiter = ':')
    @DisplayName("calculate 메소드 테스트")
    void calculate(String formula, int expected) throws Exception {
        // given
        Calculator calculator = new Calculator();
        // when
        int formulaResult = calculator.calculate(formula);
        // then
        assertThat(formulaResult).isEqualTo(expected);
    }
}