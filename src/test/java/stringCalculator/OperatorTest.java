package stringCalculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class OperatorTest {

    @ParameterizedTest
    @CsvSource("3,5")
    public void 덧셈(int first, int second){
        assertThat(Operator.ADDITION.operate(first, second)).isEqualTo(8);
    }

    @ParameterizedTest
    @CsvSource("10,5")
    public void 뺄셈(int first, int second){
        assertThat(Operator.SUBSTRACT.operate(first, second)).isEqualTo(5);
    }

    @ParameterizedTest
    @CsvSource("10,5")
    public void 곱셈(int first, int second){
        assertThat(Operator.MULTIPLICATION.operate(first, second)).isEqualTo(50);
    }

    @ParameterizedTest
    @CsvSource("200,10")
    public void 나눗셈(int first, int second){
        assertThat(Operator.DIVIDE.operate(first, second)).isEqualTo(20);
    }

    @ParameterizedTest
    @CsvSource("2 + 3 * 4 / 2")
    public void 계산하기(String string){
        assertThat(Operator.compute(string)).isEqualTo(10);
    }

}
