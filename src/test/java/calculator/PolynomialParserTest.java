package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class PolynomialParserTest {
    @ParameterizedTest
    @ValueSource(strings = {"1 - 2"
            , "1 + 2 + 3"
            , "2 + 3 * 4 / 2"
            , "1343 + 231 * 2 / 4"})
    void 올바른_형식의_수식_검증_테스트(String expression) {
        assertThat(PolynomialParser.isValid(expression)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(strings = {"123"
            , "1 + * 2 + 3"
            , "2 2 + 3 * 4 / 2"
            , "12+12-43"
            , "- 1343 + 231 * 2 / 4"})
    void 잘못된_형식의_수식_검증_테스트(String expression) {
        assertThat(PolynomialParser.isValid(expression)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(strings = {""
            , " "
            , "     "})
    void 수식이_비어있는_경우_예외가_발생한다(String expression) {
        assertThatThrownBy(() -> {
            PolynomialParser.isValid(expression);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 수식이_null인_경우_예외가_발생한다() {
        assertThatThrownBy(() -> {
            PolynomialParser.isValid(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 수식에서_피연산자_추출_테스트() {
        String expression = "1343 + 231 * 2 / 4";

        assertThat(PolynomialParser.extractOperands(expression)).containsExactly(1343, 231, 2, 4);
    }

    @Test
    void 수식에서_연산자_추출_테스트() {
        String expression = "1343 + 231 * 2 / 4";

        assertThat(PolynomialParser.extractOperators(expression)).containsExactly("+", "*", "/");
    }
}