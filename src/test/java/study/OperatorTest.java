package study;

import Calculator.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class OperatorTest {


    @DisplayName("연산자 확인")
    @Test
    void getOperator() {
        assertAll("operator",
                ()-> assertEquals(Operator.getOperator("+"),Operator.ADDITION),
                ()-> assertEquals(Operator.getOperator("-"),Operator.SUBTRACTION),
                ()-> assertEquals(Operator.getOperator("*"),Operator.MULTIPLICATION),
                ()-> assertEquals(Operator.getOperator("/"),Operator.DIVISION)
        );

    }
}
