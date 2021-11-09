package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("2단계 - 문자열 계산기 - BinomialExpression 단위 테스트")
class BinomialExpressionTest {

    @Test
    @DisplayName("calculate 테스트")
    void calculate() {
        BinomialExpression binomialExpression = new BinomialExpression(2L, 6L, "*");
        assertThat(binomialExpression.calculate())
                .isEqualTo(12L);
    }
}
