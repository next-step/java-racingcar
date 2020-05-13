package com.cheolhyeonpark.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ExpressionParserTest {

    ExpressionParser expressionParser = new ExpressionParser();

    @Test
    @DisplayName("문자열에서 수식을 가져온다")
    void getExpressionFromString() {
        //given
        String input = "1 + 2";

        //when
        Expression expression = expressionParser.getExpressionFromString(input);

        //then
        assertThat(expression.calculate()).isEqualTo(3);
    }

    @Test
    @DisplayName("숫자가 아닌 입력시 예외 발생")
    void throwExceptionWhenThereIsNonIntegerInput() {
        //given
        String input = "a + b";

        //then
        assertThatIllegalArgumentException().isThrownBy(() -> expressionParser.getExpressionFromString(input));
    }
}