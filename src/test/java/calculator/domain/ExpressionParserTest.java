package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ExpressionParserTest {

    @Test
    void parseExpression_사용자_입력을_받아_Operators_Terms_생성() {

        //given
        String[] userInput = "1 + 2 * 3".split("\\s+");

        // when
        ExpressionParser parser = new ExpressionParser(userInput);

        // then
        assertThat(parser.getOperators()).isNotNull();
        assertThat(parser.getTerms()).isNotNull();
    }
}