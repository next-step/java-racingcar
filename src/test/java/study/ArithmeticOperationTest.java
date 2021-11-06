package study;

import com.ArithmeticOperation;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class ArithmeticOperationTest {
    @Test
    void plus() {
        ArithmeticOperation ao = new ArithmeticOperation();
        assertThat(ao.plus(3, 5)).isEqualTo(8);
    }

    @Test
    void minus() {

    }

    @Test
    void multiply() {

    }

    @Test
    void divide() {

    }
}
