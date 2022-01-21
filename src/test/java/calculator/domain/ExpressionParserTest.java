package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ExpressionParserTest {

    @Test
    void parseExpression_사용자_입력을_받아_Expression_반환() {

        //given
        String[] userInput = "1 + 2 * 3".split("\\s+");

        // when
        ExpressionParser parser = new ExpressionParser();
        Expression expression = parser.parseExpression(userInput);

        // then
        assertThat(expression.getOperators().size()).isEqualTo(2);
        assertThat(expression.getTerms().size()).isEqualTo(3);
    }
}