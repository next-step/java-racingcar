package study;

import com.process.InputProcessor;
import com.util.ArithmeticOperation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

public class ArithmeticOperationTest {
    @Test
    @DisplayName("plus method test")
    void plus() {
        ArithmeticOperation oper = new ArithmeticOperation();
        assertThat(oper.plus(3, 5)).isEqualTo(8);
    }

    @Test
    @DisplayName("minus method test")
    void minus() {
        ArithmeticOperation oper = new ArithmeticOperation();
        assertThat(oper.minus(8, 5)).isEqualTo(3);
        assertThat(oper.minus(5, 8)).isEqualTo(-3);
    }

    @Test
    @DisplayName("multiply method test")
    void multiply() {
        ArithmeticOperation oper = new ArithmeticOperation();
        assertThat(oper.multiply(8, 5)).isEqualTo(40);
        assertThat(oper.multiply(5, -8)).isEqualTo(-40);
    }

    @Test
    @DisplayName("divide method test")
    void divide() {
        ArithmeticOperation oper = new ArithmeticOperation();
        assertThat(oper.divide(10, 5)).isEqualTo(2);
        assertThat(oper.divide(10, -5)).isEqualTo(-2);
    }
}
