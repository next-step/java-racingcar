package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OperatorTest {

    @DisplayName("'+' 연산자 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1, +, 1, 2", "2, +, 2, 4"})
    void plusTest(int x, String symbol, int y, int expected) {
        Operator operator = Operator.operateOf(symbol);
        assertEquals(operator.operate(x, y), expected);
    }

    @DisplayName("'-' 연산자 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1, -, 1, 0", "2, -, 2, 0"})
    void minusTest(int x, String symbol, int y, int expected) {
        Operator operator = Operator.operateOf(symbol);
        assertEquals(operator.operate(x, y), expected);
    }

    @DisplayName("'*' 연산자 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1, *, 1, 1", "2, *, 2, 4"})
    void multiplyTest(int x, String symbol, int y, int expected) {
        Operator operator = Operator.operateOf(symbol);
        assertEquals(operator.operate(x, y), expected);
    }

    @DisplayName("'/' 연산자 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1, /, 1, 1", "2, /, 2, 1"})
    void divideTest(int x, String symbol, int y, int expected) {
        Operator operator = Operator.operateOf(symbol);
        assertEquals(operator.operate(x, y), expected);
    }

}
