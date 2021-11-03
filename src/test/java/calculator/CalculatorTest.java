package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void init() {
        calculator = new Calculator();
    }

    @ValueSource(strings = "2 + 3")
    @ParameterizedTest(name = "{arguments}의 결과는 5다.")
    void addTest(String input) {
        int result = calculator.calculate(input);
        assertThat(result).isEqualTo(5);
    }

    @ValueSource(strings = "3 - 2")
    @ParameterizedTest(name = "{arguments}의 결과는 1이다.")
    void minusTest(String input) {
        int result = calculator.calculate(input);
        assertThat(result).isEqualTo(1);
    }

    @ValueSource(strings = "3 * 2")
    @ParameterizedTest(name = "{arguments}의 결과는 6이다.")
    void multipleTest(String input) {
        int result = calculator.calculate(input);
        assertThat(result).isEqualTo(6);
    }

    @ValueSource(strings = "3 / 2")
    @ParameterizedTest(name = "{arguments}의 결과는 1이다.")
    void divisionTest(String input) {
        int result = calculator.calculate(input);
        assertThat(result).isEqualTo(1);
    }

    @ValueSource(strings = "3 ^ 2")
    @ParameterizedTest(name = "{arguments} 사칙연산 기호가 아니면, 예외가 발생한다.")
    void calculateExceptionTest(String input) {

        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate(input));

    }

    @ValueSource(strings = "3 * 2 * 2 5")
    @ParameterizedTest(name = "{arguments} input이 규격에 안맞으면, 예외가 발생한다.")
    void calculateExceptionTest2(String input) {

        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate(input));

    }

    @CsvSource(value = {"3 / 2 * 3=3", "4 / 2 + 3=5", "2 - 1 * 5=5"}, delimiter = '=')
    @ParameterizedTest(name = "{arguments} 결과 테스트")
    void calculateTest(String input, int expected) {
        int result = calculator.calculate(input);
        assertThat(result).isEqualTo(expected);
    }

}