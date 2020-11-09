package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

abstract class CalculatorTest {

    Calculator calculator;

    @DisplayName("expression 에 사칙연산 기호가 아닌값이 포함되면 IllegalArgumentException 을 던진다")
    @ParameterizedTest
    @ValueSource( strings = {"1 @ 2", "1 % 2", "1 ^ 2", "1 & 2"})
    void requirement1(String expression){
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate(expression));
    }

    @DisplayName("expression 이 null 이거나 빈 공백 문자일 경우 IllegalArgumentException 을 던진다")
    @ParameterizedTest
    @NullAndEmptySource
    void requirement2(String expression){
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate(expression));
    }

    @DisplayName("expression 이 숫자로 시작하지 않으면 IllegalArgumentException 을 던진다")
    @ParameterizedTest
    @ValueSource(strings = {
            "+ 1 * 3",
            "일 + 2",
            "# + 2",
            "A + 2"})
    void requirment3(String expression){
        assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate(expression));
    }

    @DisplayName("사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다")
    @ParameterizedTest
    @CsvSource(value = {
            "1 + 2 * 3=9",
            "1 + 2 + 3 / 2=3",
            "2 + 3 * 4 / 2=10",
            "8 * 4 - 10 / 2=11"}, delimiter = '=')
    void calculate(String expression, Integer expected){
        assertThat(calculator.calculate(expression)).isEqualTo(expected);
    }

}

class DefaultCalculatorTest extends CalculatorTest{

    @BeforeEach
    void setUp(){
        calculator = new Calculator.Default();
    }

}