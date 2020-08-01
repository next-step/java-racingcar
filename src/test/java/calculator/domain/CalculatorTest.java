package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CalculatorTest {

    @DisplayName("디폴트 생성자 예외 처리 테스트")
    @Test
    void defaultConstructTest() {
        assertThatIllegalArgumentException().isThrownBy(Calculator::new);
    }

    @DisplayName("입력 값 공백 문자일 경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = "")
    void emptyStringTest(String emptyString) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Calculator(emptyString));
    }

    @DisplayName("잘못된 입력 수식 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"3 ^", "10 % 5", "1 @ 3"})
    void wrongCaseTest(String expression) {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Calculator calculator = new Calculator(expression);
            calculator.calculate();
        });
    }

    @DisplayName("사칙 연산 수행 테스트")
    @ParameterizedTest
    @CsvSource(value = {"30 / 6 : 5", "20 * 40 : 800", "5 + 10 : 15", "60 - 30 : 30"}, delimiter = ':')
    void calculateTest(String expression, int result) {
        assertThat(new Calculator(expression).calculate())
                .isEqualTo(result);
    }
}
