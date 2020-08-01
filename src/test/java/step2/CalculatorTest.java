package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step2.util.StringUtils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static step2.common.ArithmethicConstants.*;

class CalculatorTest {

    private Calculator calculator = new Calculator();

    @ParameterizedTest
    @CsvSource(value = {"1 + 2:3","1:1","1 + 2 + 3:5"}, delimiter = ':')
    @DisplayName("입력 값이 공백을 기준으로 split이 제대로 되는지 확인")
    void splitInputValBySpaceTest(String inputVal,int splitSize) {
        String[] strings = StringUtils.splitInputValBySpace(inputVal);
        assertThat(strings).hasSize(splitSize);
    }

    @Test
    @DisplayName("입력값이 '' 일때 테스트")
    void argsStringNullCheckTest(){
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                String inputVal = "";
                StringUtils.splitInputValBySpace(inputVal);
            });
    }

    @Test
    @DisplayName("입력값이 Null 일때 테스트")
    void argsNullCheckTest(){
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                StringUtils.splitInputValBySpace(null);
            });
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2:3","0:2:2","0:0:0"}, delimiter = ':')
    @DisplayName("입력값 더하기 값이 원하는 값이 나오는지 확인")
    void addTest(int firstVal, int secondVal, int resultVal) {
        int addResult = OperatorType.calculate(OPERATION_ADDITION,firstVal,secondVal);
        assertThat(addResult).isEqualTo(resultVal);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2:-1","3:1:2","3:3:0"}, delimiter = ':')
    @DisplayName("입력값 빼기 값이 원하는 값이 나오는지 확인")
    void minus(int firstVal, int secondVal, int resultVal) {
        int minusResult = OperatorType.calculate(OPERATION_SUBTRACT,firstVal,secondVal);
        assertThat(minusResult).isEqualTo(resultVal);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2:2","0:2:0","3:1:3"}, delimiter = ':')
    @DisplayName("입력값 곱하기 값이 원하는 값이 나오는지 확인")
    void multiply(int firstVal, int secondVal, int resultVal) {
        int multiplyResult = OperatorType.calculate(OPERATION_MULTIPLY,firstVal,secondVal);
        assertThat(multiplyResult).isEqualTo(resultVal);
    }

    @ParameterizedTest
    @CsvSource(value = {"10:5:2","0:2:0","2:2:1"}, delimiter = ':')
    @DisplayName("입력값 나누기 값이 원하는 값이 나오는지 확인")
    void devide(int firstVal, int secondVal, int resultVal) {
        int devideResult = OperatorType.calculate(OPERATION_DIVIDE,firstVal,secondVal);
        assertThat(devideResult).isEqualTo(resultVal);
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 2:3","1 / 1 :1","1 * 2 + 3:5","4 - 1:3"}, delimiter = ':')
    @DisplayName("통합테스트")
    void integrationTest(String inputVal,int resultVal){
        int calculatedVal = calculator.process(inputVal);
        assertThat(calculatedVal).isEqualTo(resultVal);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 # 2","1 - 2 & 3"})
    @DisplayName("통합테스트 예외(잘못된연산기호)")
    void invaludOperationExceptionTest(String inputVal){
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> {
                calculator.process(inputVal);
            });
    }

    @ParameterizedTest
    @ValueSource(strings = {"1 / 0"})
    @DisplayName("통합테스트 예외(0으로 나눌때)")
    void divideZeroExceptionTest(String inputVal){
        assertThatExceptionOfType(ArithmeticException.class)
            .isThrownBy(() -> {
                calculator.process(inputVal);
            });
    }


}