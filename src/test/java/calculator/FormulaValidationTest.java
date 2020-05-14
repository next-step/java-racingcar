package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

class FormulaValidationTest {

    private final String SPLIT_REGEX = " ";

    @DisplayName("식의 항이 3개 미만 이거나 식의 항이 짝수개 이면 IllegalArgumentException 발생")
    @ParameterizedTest
    @CsvSource({"1", "1 + ", "+ +", "1 + 1 +", "1 + 1 3"})
    public void validationCheckElementCount(String formula) {
        Throwable throwable = catchThrowable(() -> {
            FormulaValidation formulaValidation = new FormulaValidation(formula.split(SPLIT_REGEX));
            String[] formulaChecked = formulaValidation.check();
        });

        assertThat(throwable).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("There are errors in the number of operators and operands.");
    }

    @DisplayName("항의 순서가 홀수 항은 피연산자, 짝수 항은 연산자 가 아니면 IllegalArgumentException 발생")
    @ParameterizedTest
    @CsvSource({"1 + 1 1 1", "1 + 1 + 2 + -" })
    public void validationCheckElementOrder(String formula) {
        Throwable throwable = catchThrowable(() -> {
            FormulaValidation formulaValidation = new FormulaValidation(formula.split(SPLIT_REGEX));
            String[] formulaChecked = formulaValidation.check();
        });

        assertThat(throwable).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("There is an error in the order of operators and operands.");
    }
}