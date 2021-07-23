package calculator;

import calculator.Operator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class OperatorTest {
    @DisplayName("Operator of 테스트")
    @CsvSource({
            "+,true",
            "-,true",
            "*,true",
            "/,true",
            "),false",
            "//,false"
    })
    @ParameterizedTest
    public void ofTest(String strOperator, boolean isPresent) {
        assertThat(
                Operator.of(strOperator).isPresent()
        ).isEqualTo(isPresent);
    }

    private void calTest(Operator operator, int leftNumber, int rightNumber, int resultNumber) {
        assertThat(
                operator.calculation(leftNumber, rightNumber)
        ).isEqualTo(resultNumber);
    }

    @DisplayName("덧셈 테스트")
    @CsvSource({
            "1,1,2",
            "1,2,3",
            "0,0,0",
            "-5,-2,-7",
            "-2,2,0"
    })
    @ParameterizedTest
    public void addTest(int leftNumber, int rightNumber, int resultNumber) {
        calTest(Operator.ADD, leftNumber, rightNumber, resultNumber);
    }

    @DisplayName("뺄셈 테스트")
    @CsvSource({
            "1,1,0",
            "1,2,-1",
            "0,0,0",
            "-5,-2,-3",
            "-2,2,-4"
    })
    @ParameterizedTest
    public void minTest(int leftNumber, int rightNumber, int resultNumber) {
        calTest(Operator.MIN, leftNumber, rightNumber, resultNumber);
    }

    @DisplayName("곱셈 테스트")
    @CsvSource({
            "1,1,1",
            "1,2,2",
            "0,0,0",
            "-5,-2,10",
            "-2,2,-4",
            "-2,0,0"
    })
    @ParameterizedTest
    public void mulTest(int leftNumber, int rightNumber, int resultNumber) {
        calTest(Operator.MUL, leftNumber, rightNumber, resultNumber);
    }

    @DisplayName("나눗셈 테스트")
    @CsvSource({
            "1,1,1",
            "1,2,0",
            "0,1,0",
            "-5,-2,2",
            "-2,2,-1",
            "0,-2,0"
    })
    @ParameterizedTest
    public void divTest(int leftNumber, int rightNumber, int resultNumber) {
        calTest(Operator.DIV, leftNumber, rightNumber, resultNumber);
    }
}