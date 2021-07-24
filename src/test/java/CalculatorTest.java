import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    @DisplayName("덧셈 연산 결과")
    private void decide_test() {

        String str = "1 + 2";
        Calculator calculator = new Calculator(str);

        assertEquals(3, calculator.getResult());
    }

}