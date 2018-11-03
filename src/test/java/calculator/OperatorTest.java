package calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class OperatorTest {

    @Test
    public void 더하기() {
        int result = Operator.findOperator("+").result(2, 3);
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void 빼기() {
        int result = Operator.findOperator("-").result(7, 2);
        assertThat(result).isEqualTo(5);
    }

    @Test
    public void 나누기() {
        int result = Operator.findOperator("/").result(8, 2);
        assertThat(result).isEqualTo(4);
    }

    @Test
    public void 곱하기() {
        int result = Operator.findOperator("*").result(4, 3);
        assertThat(result).isEqualTo(12);
    }

}