package stringCalculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculateOperatorTest {

    @Test
    @DisplayName("더하기")
    public void add() {
        assertThat(CalculateOperator.ADD.calculate(1,2)).isEqualTo(3);
    }

    @Test
    @DisplayName("빼기")
    public void subtract() {
        assertThat(CalculateOperator.SUBTRACT.calculate(5,2)).isEqualTo(3);
    }
    @Test
    @DisplayName("곱하기")
    public void multiply() {
        assertThat(CalculateOperator.MULTIPLY.calculate(4,5)).isEqualTo(20);
    }
    @Test
    @DisplayName("나누기")
    public void divide() {
        assertThat(CalculateOperator.DIVIDE.calculate(10,2)).isEqualTo(5);
    }
    @Test
    @DisplayName("0으로 나눌때 예외처리")
    public void divedeZeoExceptionTest() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CalculateOperator.DIVIDE.calculate(10,0);
        });
    }
}