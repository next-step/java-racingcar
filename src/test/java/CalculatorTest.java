import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class CalculatorTest {

    Calculator calc = new Calculator();

    @Test
    void splitString() {
        String[] value = "1 + 2".split(" ");
        assertThat(value).contains("+");
    }

    @Test
    void addOperationTest() {
        String[] value = "1 + 2".split(" ");
        assertThat(calc.add(value[0], value[2])).isEqualTo(3);
    }

    @Test
    void subOperationTest() {
        String[] value = "1 - 2".split(" ");
        assertThat(calc.sub(value[0], value[2])).isEqualTo(-1);
    }

    @Test
    void multiplicationOperationTest() {
        String[] value = "5 * 7".split(" ");
        assertThat(calc.multiply(value[0], value[2])).isEqualTo(35);
    }

    @Test
    void divideOperationTest() {
        String[] value = "32 * 8".split(" ");
        assertThat(calc.divide(value[0], value[2])).isEqualTo(4);
    }

    @Test
    @DisplayName("Check calculation result")
    void usingCalculateMethod() {
        String[] value = "15 * 4".split(" ");
        assertThat(calc.calculate(value[0], value[1], value[2])).isEqualTo(60);
    }

    @Test
    @DisplayName("Check Exception - Not Defined Operator")
    void usingCalculateMethod_operationException() {
        String[] value = "15 [ 30".split(" ");
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calc.calculate(value[0], value[1], value[2]));
    }

    // 기능을 모두 totalCalculate로 옮김. 그대로 둘 필요가 있을까?
    @Test
    void MultiOperationTest() {
        String[] input = "1 + 2 + 3".split(" ");
        Deque<String> value = new LinkedList<>(Arrays.asList(input));
        int result = 0;

        // Refactoring 어떻게?
        while (value.size() != 1) {
            String[] temp = {"", "", ""};
            temp[0] = value.pop();
            temp[1] = value.pop();
            temp[2] = value.pop();
            result = calc.calculate(temp[0], temp[1], temp[2]);
            value.addFirst(String.valueOf(result));
        }
        assertThat(result).isEqualTo(6);
    }

    // 상위 코드에 구현한 로직을 Calculator의 Method, totalCalculate로 구현완료.
    // 이 경우 상위 테스트는 그대로 두는게 맞을지?
    @ParameterizedTest
    @ValueSource(strings = {"1 + 3 - 2"})
    @DisplayName("Several Calculation with Only one Method used")
    void MultiOperationCalculationWithOneMethod(String input) {
        assertThat(calc.totalCalculate(input)).isEqualTo(2);
    }

    //조금 복잡한 경우?
    @ParameterizedTest
    @ValueSource(strings = {"1 * 3 - 23 / 4 * 4"})
    @DisplayName("Several Calculation with Only one Method used_Complex")
    void MultiOperationCalculationWithOneMethod2(String input) {
        assertThat(calc.totalCalculate(input)).isEqualTo(-20);
    }

    //Exception Check
    //Input 자체가 Null일 경우는?
    @ParameterizedTest
    @ValueSource(strings = {""})
    void NullStringInputValueExceptionTest(String input) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calc.totalCalculate(input));
    }
}