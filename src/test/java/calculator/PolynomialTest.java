package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class PolynomialTest {
    @Test
    void 다항식_생성_테스트() {
        String expression = "12 + 252 - 3";
        Polynomial polynomial = Polynomial.createPolynomialWithExpression(expression);

        assertThat(polynomial).isInstanceOf(Polynomial.class);
    }

    @Test
    void 잘못된_수식으로_다항식을_생성하면_예외가_발생한다() {
        assertThatThrownBy(() -> {
            Polynomial.createPolynomialWithExpression("12 + * 3");
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