package calculator;

import calculator.enums.Operator;
import calculator.utils.Validator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {

    @Test
    @DisplayName("덧셈")
    public void add() throws Exception {
        //given
        String expression = "5 + 5 + 10";

        //when
        String[] splitExpression = expression.split(" ");
        StringCalculator stringCalculator = new StringCalculator();
        int result = stringCalculator.calculate(splitExpression);

        //then
        assertThat(result).isEqualTo(20);
    }
}