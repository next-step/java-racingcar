package calculator.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    public void 이항연산_정상동작() {
        //given
        Calculator calculator = new Calculator();

        //when
        double plus = calculator.doBinaryOperation(3, 5, Operator.PLUS);
        double minus = calculator.doBinaryOperation(3, 5, Operator.MINUS);
        double multiply = calculator.doBinaryOperation(3, 5, Operator.MULTIPLY);
        double divide = calculator.doBinaryOperation(10, 5, Operator.DIVIDE);

        //then
        assertThat(plus).isEqualTo(8);
        assertThat(minus).isEqualTo(-2);
        assertThat(multiply).isEqualTo(15);
        assertThat(divide).isEqualTo(2);
    }

    @Test
    public void 다항연산_정상동작() {
        //given
        Calculator calculator = new Calculator();

        //when
        double ret = calculator
            .doMultipleOperation(new ArrayList<>(Arrays.asList(85, 10, 45, 2, 4))
                , new ArrayList<>(Arrays.asList(Operator.PLUS, Operator.MINUS, Operator.MULTIPLY, Operator.DIVIDE)));

        //then
        assertThat(ret).isEqualTo(25.0);
    }
}