package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class OperatorTest {

    @DisplayName("덧셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"2,+,2,4", "3,+,3,6"})
    void plusTest(long num1, String symbol, long num2, long expected) {
        Operator operator = Operator.findOperator(symbol);
        assertEquals(operator.calculate(num1, num2), expected);
    }
}
