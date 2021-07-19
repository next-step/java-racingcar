package step2;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class OperationTest {

    @Test
    void testPlus(){
        int plus = Operation.PLUS.calcuate(1,2);
        assertThat(plus).isEqualTo(3);
//        assertThat(plus).isEqualTo(4);
    }

    @Test
    void testMinus(){
        int minus = Operation.MINUS.calcuate(3,2);
        assertThat(minus).isEqualTo(1);
    }

    @Test
    void testMuliply(){
        int multiply = Operation.MULIPLY.calcuate(2,5);
        assertThat(multiply).isEqualTo(10);
    }

    @Test
    void testDivide(){
        int divide = Operation.DIVIDE.calcuate(4,2);
        assertThat(divide).isEqualTo(2);
        divide = Operation.DIVIDE.calcuate(7,3);
        assertThat(divide).isEqualTo(2);
    }

}