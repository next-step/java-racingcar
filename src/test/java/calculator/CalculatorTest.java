package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CalculatorTest {

    @Test
    @DisplayName("입력값 검증테스트 - 빈 문자열")
    void validateInput_isEmpty() {
        // given
        Calculator calculator = new Calculator();

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy( () -> calculator.validateInput(null) )
                .withMessageMatching("수식을 입력해 주세요");

        assertThatIllegalArgumentException()
                .isThrownBy( () -> calculator.validateInput("") )
                .withMessageMatching("수식을 입력해 주세요");
    }

    @Test
    @DisplayName("입력값 검증테스트 - 사칙연산 레이아웃")
    void validateInput_isValidOperationLayout() {
        // given
        Calculator calculator = new Calculator();

        // when, then
        assertThatIllegalArgumentException()
                .isThrownBy( () -> calculator.validateInput("2 2 4") )
                .withMessageMatching("수식의 구성이 올바르지 않습니다. 다시 입력해 주세요");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> calculator.validateInput("- 2 4") )
                .withMessageMatching("수식의 구성이 올바르지 않습니다. 다시 입력해 주세요");

        assertThatIllegalArgumentException()
                .isThrownBy(() -> calculator.validateInput("- & 4") )
                .withMessageMatching("수식의 구성이 올바르지 않습니다. 다시 입력해 주세요");
    }

    @Test
    @DisplayName("calculate 메소드 테스트")
    void calculate() throws Exception {
        // given
        Calculator calculator = new Calculator();

        // when
        String formula = "2 * 8 - 4";
        int formulaResult = calculator.calculate(formula);

        // then
        assertThat(formulaResult).isEqualTo(12);
    }
}