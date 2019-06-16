package stringCalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculateOperatorTest {

    @Test
    public void caculateOperatorTest() {
        assertThat(CalculateOperator.ADD.calculate(1,2)).isEqualTo(3);
        assertThat(CalculateOperator.SUBTRACT.calculate(5,2)).isEqualTo(3);
        assertThat(CalculateOperator.MULTIPLY.calculate(4,5)).isEqualTo(20);
        assertThat(CalculateOperator.DIVIDE.calculate(10,2)).isEqualTo(5);
    }

    @Test
    public void divedeZeoExceptionTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CalculateOperator.DIVIDE.calculate(10,0);
        });
    }
}