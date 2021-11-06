package study;

import com.process.InputProcessor;
import com.util.ArithmeticOperation;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class ArithmeticOperationTest {
    @Test
    void plus() {
        ArithmeticOperation oper = new ArithmeticOperation();
        assertThat(oper.plus(3, 5)).isEqualTo(8);
    }

    @Test
    void minus() {
        ArithmeticOperation oper = new ArithmeticOperation();
        assertThat(oper.minus(8, 5)).isEqualTo(3);
        assertThat(oper.minus(5, 8)).isEqualTo(-3);
    }

    @Test
    void multiply() {
        ArithmeticOperation oper = new ArithmeticOperation();
        assertThat(oper.multiply(8, 5)).isEqualTo(40);
        assertThat(oper.multiply(5, -8)).isEqualTo(-40);
    }

    @Test
    void divide() {
        ArithmeticOperation oper = new ArithmeticOperation();
        assertThat(oper.divide(10, 5)).isEqualTo(2);
        assertThat(oper.divide(10, -5)).isEqualTo(-2);
    }

    @Test
    void subCalculate() {
        InputProcessor processor = new InputProcessor();
        assertThat(processor.subCalculate(2, "-", 3)).isEqualTo(-1);
        assertThat(processor.subCalculate(2, "+", 3)).isEqualTo(5);
        assertThat(processor.subCalculate(2, "*", 3)).isEqualTo(6);
        assertThat(processor.subCalculate(4, "/", 2)).isEqualTo(2);
    }

    @Test
    void calculate() {
        InputProcessor processor = new InputProcessor();
        assertThat(processor.calculate("2 + 3 * 4 / 2")).isEqualTo(10);
    }
}
