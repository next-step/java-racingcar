package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExpressionTest {

    @DisplayName("수식 생성 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"1 + 2 - 3", "2 * 2 / 4"})
    void createTest(String strExp) {
        Expression expression = new Expression(strExp);

        assertThat(expression).isNotNull();
    }

    @DisplayName("올바르지 않은 수식 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1 + 2 - ", "2 * 2 / 4 +"})
    void incorrectExpressionTest(String strExp) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Expression(strExp))
                .withMessageContaining("올바르지 않은 수식입니다.");
    }

    @DisplayName("올바르지 않은 숫자 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1 + 2 - a", "2 * 2 / 4 + ["})
    void incorrectNumberTest(String strExp) {
        assertThatThrownBy(() -> new Expression(strExp))
                .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("수식 계산 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1 + 2 - 3,0", "2 * 2 / 4,1"})
    void calculateTest(String strExp, int expected) {
        Expression expression = new Expression(strExp);

        assertThat(expression.calculate()).isEqualTo(expected);
    }
}
