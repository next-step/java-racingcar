package calculator.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class CalculatorTest {

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