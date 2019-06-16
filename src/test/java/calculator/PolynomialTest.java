package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class PolynomialTest {
    @ParameterizedTest
    @ValueSource(strings = {"123"
            , "1 - 2"
            , "1 + 2 + 3"
            , "2 + 3 * 4 / 2"
            , "1343 + 231 * 2 / 4"})
    void 올바른_형식의_수식으로_다항식_생성_테스트(String expression) {
        Polynomial polynomial = Polynomial.createPolynomialWithExpression(expression);

        assertThat(polynomial).isInstanceOf(Polynomial.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 + * 2 + 3"
            , "2 2 + 3 * 4 / 2"
            , "12+12-43"
            , "- 1343 + 231 * 2 / 4"})
    void 잘못된_형식의_수식으로_다항식을_생성하면_예외가_발생한다(String expression) {
        assertThatThrownBy(() -> {
            Polynomial.createPolynomialWithExpression(expression);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({"1 - 2, -1"
            , "1 + 2 + 3, 6"
            , "2 + 3 * 4 / 2, 10"
            , "1343 + 231 * 2 / 4, 787"
            , "25 + 30 - 12 * 20 / 5, 172"
            , "1 + 1 - 1 * 1 / 1, 1"
    })
    void 다항식_연산_수행_테스트(String expression, int expectedResult) {
        Polynomial polynomial = Polynomial.createPolynomialWithExpression(expression);

        assertThat(polynomial.calculate()).isEqualTo(expectedResult);
    }
}