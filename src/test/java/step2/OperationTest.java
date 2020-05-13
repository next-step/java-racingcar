package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("연산자 테스트")
class OperationTest {

    @DisplayName("더하기 연산자를 테스트한다")
    @ParameterizedTest(name = "{0} + {1} = {2}")
    @CsvSource({"1,2,3","2,5,7","-1,2,1"})
    void 더하기(Double firstNumber, Double secondNumber, Double result) {
        assertThat(Operation.PLUS.calculate(firstNumber, secondNumber)).isEqualTo(result);
    }

    @DisplayName("뺴기 연산자를 테스트한다")
    @ParameterizedTest(name = "{0} - {1} = {2}")
    @CsvSource({"3,2,1","7,5,2","4,2,2"})
    void 뺴기(Double firstNumber, Double secondNumber, Double result) {
        assertThat(Operation.MINUS.calculate(firstNumber, secondNumber)).isEqualTo(result);
    }

    @DisplayName("곱하기 연산자를 테스트한다")
    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource({"1,2,2","2,5,10","-1,2,-2"})
    void 곱하기(Double firstNumber, Double secondNumber, Double result) {
        assertThat(Operation.MULTIPLY.calculate(firstNumber, secondNumber)).isEqualTo(result);
    }

    @DisplayName("나누기 연산자를 테스트한다")
    @ParameterizedTest(name = "{0} / {1} = {2}")
    @CsvSource({"1,2,0.5","10,5,2","4,2,2"})
    void 나누기(Double firstNumber, Double secondNumber, Double result) {
        assertThat(Operation.DIVIDE.calculate(firstNumber, secondNumber)).isEqualTo(result);
    }
}