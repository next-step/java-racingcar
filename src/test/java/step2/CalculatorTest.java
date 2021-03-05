package step2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    @DisplayName("덧셈 테스트 : 1 + 4 = 5")
    void plusTest() {
        String input = "1 + 4";
        assertEquals(5, Calculator.plus(input));
    }
}
