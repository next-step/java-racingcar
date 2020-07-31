import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.assertThat;

class ArithmeticArgumentsTest {
    private ArithmeticArguments args;

    @BeforeEach
    void setUp() {
        this.args = new ArithmeticArguments("2 + 3 * 4 / 2");
    }

    @Test
    void nextOperandsTest() {
        assertThat(args.nextOperands()).isEqualTo(new Integer[] {2, 3});
    }

    @ParameterizedTest
    @CsvSource(value = {"1:5", "-1:7", "9:-3"}, delimiter = ':')
    void nextOperatorTest(int a, int b) {
        assertThat(args.nextOperator().operate(a, b)).isEqualTo(6);
    }


    @Test
    void hasNextOperatorTest(String operator) {
        assertThat(args.hasNextOperator()).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void setResultTest(int nums) {
        args.setResult(nums);
        assertThat(args.getResult()).isEqualTo(nums);
    }

    @Test
    void getResultTest() {
        assertThat(Calculator.calculate(args)).isEqualTo(10);
    }
}