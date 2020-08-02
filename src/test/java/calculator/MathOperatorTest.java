package calculator;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MathOperatorTest {

    @Test
    public void hasMathOperator_테스트() throws Exception {
        String code = "*";
        assertEquals(Boolean.TRUE, MathOperator.hasMathOperator(code));
    }

    @Test
    public void findByMathOperatorCode_테스트() throws Exception {
        String code = "/";
        assertEquals(MathOperator.DIVIDE, MathOperator.findByMathOperatorCode(code));
    }

}