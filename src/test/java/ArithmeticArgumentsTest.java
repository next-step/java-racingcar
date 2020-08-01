import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class ArithmeticArgumentsTest {
    private ArithmeticArguments args;

    @BeforeEach
    void setUp() {
        this.args = new ArithmeticArguments("2 + 3 * 4 / 2");
    }

    @Test
    void nextOperandsTest() {
        assertThat(this.args.nextOperand()).isEqualTo(2);
        assertThat(this.args.nextOperand()).isEqualTo(3);
        assertThat(this.args.nextOperand()).isEqualTo(4);
        assertThat(this.args.nextOperand()).isEqualTo(2);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:5", "-1:7", "9:-3"}, delimiter = ':')
    void nextOperatorTest(int a, int b) {
        assertThat(args.nextOperator().operate(a, b)).isEqualTo(6);
    }


    @Test
    void hasNextOperatorTest() {
        assertThat(args.hasNextOperator()).isTrue();
        assertThat(args.nextOperator()).isEqualTo(Operator.ADD);
        assertThat(args.hasNextOperator()).isTrue();
        assertThat(args.nextOperator()).isEqualTo(Operator.MULTIPLY);
        assertThat(args.hasNextOperator()).isTrue();
        assertThat(args.nextOperator()).isEqualTo(Operator.DIVIDE);
        assertThat(args.hasNextOperator()).isFalse();
    }
}