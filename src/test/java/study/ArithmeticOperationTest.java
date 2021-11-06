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

    }

    @Test
    void divide() {

    }
}
