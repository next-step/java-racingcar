package mission1.step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperatorTypeTest {

    @Test
    @DisplayName("덧셈")
    public void add() {
        Integer value =  OperatorType.searchOperation("+").calculate(1, 3);
        assertEquals(value, 4);
    }

    @Test
    @DisplayName("뺄셈")
    public void minus() {
        Integer value =  OperatorType.searchOperation("-").calculate(1, 2);
        assertEquals(value, -1);
    }

    @Test
    @DisplayName("곱셈")
    public void multipication() {
        Integer value =  OperatorType.searchOperation("*").calculate(2, 2);
        assertEquals(value, 4);
    }

    @Test
    @DisplayName("나눗셈")
    public void divide() {
        Integer value =  OperatorType.searchOperation("/").calculate(5, 2);
        assertEquals(value, 2);
    }
}



