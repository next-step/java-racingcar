package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

class ExpressionTest {

    @ParameterizedTest()
    @Test
    void Terms와_Operators를_받아_생성() {

        // given
        ArrayList<Long> terms = new ArrayList<>(Arrays.asList(1L, 2L));
        ArrayList<String> operators = new ArrayList<>(Arrays.asList("+"));

        // when
        Expression expression = new Expression(terms, operators);

        // then
        assertThat(expression.getTerms()).isEqualTo(terms);
        assertThat(expression.getOperators()).isEqualTo(operators);
    }
}