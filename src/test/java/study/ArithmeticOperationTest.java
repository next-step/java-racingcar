package study;

import com.ArithmeticOperation;
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

    }
}
