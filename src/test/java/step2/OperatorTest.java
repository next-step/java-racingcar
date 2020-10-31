package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class OperatorTest {
    void testEquality(Operator op, int lhs, int rhs, int expect) {
        assertThat(op.operate(lhs, rhs)).isEqualTo(expect);
    }

    @DisplayName("test for `addition(+)` operator")
    @CsvSource({
            "5,5,10",
            "5,-5,0",
            "0,-5,-5"
    })
    @ParameterizedTest
    void add(int lhs, int rhs, int expect) {
        testEquality(Operator.ADD, lhs, rhs, expect);
    }

    @DisplayName("test for `subtraction(-)` operator")
    @CsvSource({
            "5,5,0",
            "0,-5,5",
            "-5,5,-10"
    })
    @ParameterizedTest
    void subtract(int lhs, int rhs, int expect) {
        testEquality(Operator.SUBTRACT, lhs, rhs, expect);
    }

    @DisplayName("test for `multiplication(*)` operator")
    @CsvSource({
            "5,5,25",
            "5,-5,-25",
            "0,5,0"
    })
    @ParameterizedTest
    void multiply(int lhs, int rhs, int expect) {
        testEquality(Operator.MULTIPLY, lhs, rhs, expect);
    }

    @DisplayName("test for `division(/)` operator")
    @CsvSource({
            "0,5,0",
            "4,5,0",
            "5,3,1"
    })
    @ParameterizedTest
    void divide(int lhs, int rhs, int expect) {
        testEquality(Operator.DIVIDE, lhs, rhs, expect);
    }

    @DisplayName("test for `division(/)` with exception case")
    @Test
    void divideException() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Operator.DIVIDE.operate(5, 0))
                .withMessageMatching(".* by zero$");
    }
}
