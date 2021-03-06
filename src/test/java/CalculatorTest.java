import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CalculatorTest {

    Calculator calculator;

    @BeforeAll
    void init() {
        calculator = new Calculator();
    }

    @DisplayName("입력값에 빈 값이 들어갈 경우")
    @Test
    void nullTest() {
        String testValue = null;

        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.progress(testValue));
    }

    @DisplayName("입력값이 잘못된 경우 , 공백인 경우, 사칙연산 기호가 아닌경우 테스트")
    @ParameterizedTest
    @ValueSource(strings = {
            "1 +",
            " ",
            " + 1",
            "1",
            "1 + 1 + +",
            "",
            "1 + 1 + 1 +",
            "1 + ",
            "1 x 1",
            "1 * 1 * 1 * 1 x",
            "1 * 1 * x"})
    void throwIlligalArgumentExceptionTest(String value) {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.progress(value));
    }

    @DisplayName("덧셈 뺄셈 곱셈 나눗셈 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:+:1:2", "1:*:1:1", "1:-:1:0", "1:/:1:1"} , delimiter = ':')
    void calculateTest(int input1, String operator, int input2, int result) {
        Assertions.assertEquals(result , Operation.of(operator).getResult(input1, input2));
    }

    @DisplayName("모든 사칙연산 기능 테스트")
    @Test
    void allOperatorCalculateTest () {
        String numbersAndOperators = "1 + 1 * 1 / 1 - 1";
        Assertions.assertEquals(1, calculator.progress(numbersAndOperators));
    }

    @DisplayName("나눴을때 정수로 떨어지는지 확인하는 테스트")
    @Test
    void divideResultEqualsEssenceTest() {
        Assertions.assertEquals(0, Operation.of("/").getResult(1, 2));
    }
}
