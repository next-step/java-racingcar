package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {

    @Test
    @DisplayName("덧셈")
    public void plus() {
        assertThat(Operator.PLUS.apply(1, 2)).isEqualTo(3);
    }

    @Test
    @DisplayName("뺄셈")
    public void minus() {
        assertThat(Operator.MINUS.apply(1, 2)).isEqualTo(-1);
    }

    @Test
    @DisplayName("곱셈")
    public void multiply() {
        assertThat(Operator.MULTIPLY.apply(1, 2)).isEqualTo(2);
    }

    @Test
    @DisplayName("나눗셈")
    public void divide() {
        assertThat(Operator.DIVIDE.apply(2, 1)).isEqualTo(2);
    }

    @ParameterizedTest
    @CsvSource(value = {
        "+,1,2,3",
        "-,1,2,-1",
        "*,1,2,2",
        "/,2,1,2"
    })
    @DisplayName("연산자에 따라 계산하는지 확인")
    public void applyWithOperator(char op, int left, int right, int result) {
        assertThat(Operator.calculate(op, left, right)).isEqualTo(result);
    }
}
