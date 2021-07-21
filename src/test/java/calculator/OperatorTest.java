package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class OperatorTest {

    @ParameterizedTest(name = "ADDITION 타입 연산 테스트")
    @CsvSource(value = {"1,2,3", "5,3,8", "100,200,300"})
    public void additionTest(int first, int second, int result) {
        assertThat(Operator.ADDITION.operate(first, second))
                .isEqualTo(result);
    }

    @ParameterizedTest(name = "SUBTRACTION 타입 연산 테스트")
    @CsvSource(value = {"1,2,-1", "5,3,2", "100,200,-100"})
    public void subtractionTest(int first, int second, int result) {
        assertThat(Operator.SUBTRACTION.operate(first, second))
                .isEqualTo(result);
    }

    @ParameterizedTest(name = "SUBTRACTION 타입 연산 테스트")
    @CsvSource(value = {"1,2,2", "5,-3,-15", "100,0,0"})
    public void multiplicationTest(int first, int second, int result) {
        assertThat(Operator.MULTIPLICATION.operate(first, second))
                .isEqualTo(result);
    }

}