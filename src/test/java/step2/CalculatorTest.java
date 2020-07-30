package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp(){
        calculator = new Calculator();
    }

    @ParameterizedTest
    @CsvSource(value = {"1 + 2:3","1:1","1 + 2 + 3:5"}, delimiter = ':')
    @DisplayName("입력 값이 공백을 기준으로 split이 제대로 되는지 확인")
    void splitInputValBySpaceTest(String inputVal,int splitSize) {
        String[] strings = calculator.splitInputValBySpace(inputVal);
        assertThat(strings).hasSize(splitSize);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2:3","0:2:2","0:0:0"}, delimiter = ':')
    @DisplayName("입력값 더하기 값이 원하는 값이 나오는지 확인")
    void addTest(int firstVal, int secondVal, int resultVal) {
        int addResult = calculator.add(firstVal, secondVal);
        assertThat(addResult).isEqualTo(resultVal);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2:-1","3:1:2","3:3:0"}, delimiter = ':')
    @DisplayName("입력값 빼기 값이 원하는 값이 나오는지 확인")
    void minus(int firstVal, int secondVal, int resultVal) {
        int minusResult = calculator.minus(firstVal, secondVal);
        assertThat(minusResult).isEqualTo(resultVal);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2:2","0:2:0","3:1:3"}, delimiter = ':')
    @DisplayName("입력값 곱하기 값이 원하는 값이 나오는지 확인")
    void multiply(int firstVal, int secondVal, int resultVal) {
        int multiplyResult = calculator.multiply(firstVal, secondVal);
        assertThat(multiplyResult).isEqualTo(resultVal);
    }

    @ParameterizedTest
    @CsvSource(value = {"10:5:2","0:2:0","2:2:1"}, delimiter = ':')
    @DisplayName("입력값 나누기 값이 원하는 값이 나오는지 확인")
    void devide(int firstVal, int secondVal, int resultVal) {
        int devideResult = calculator.devide(firstVal, secondVal);
        assertThat(devideResult).isEqualTo(resultVal);
    }

}