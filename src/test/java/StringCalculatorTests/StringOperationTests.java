package StringCalculatorTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@DisplayName("문자열 계산기 연산 테스트")
public class StringOperationTests {

    @DisplayName("덧셈 계산")
    @ParameterizedTest
    @CsvSource(value = {"2,3,5", "1,0,1", "5,1,6"})
    public void stringAddTest(String firstNumber, String secondNumber, Integer expectedResult) {
        Integer actualResult = StringOperation.ADD.operate(firstNumber, secondNumber);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @DisplayName("뺄셈 계산")
    @ParameterizedTest
    @CsvSource(value = {"3,2,1", "5,0,5", "5,1,4"})
    public void stringAddTest(String firstNumber, String secondNumber, Integer expectedResult) {
        Integer actualResult = StringOperation.SUBTRACT.operate(firstNumber, secondNumber);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @DisplayName("곱셈 계산")
    @ParameterizedTest
    @CsvSource(value = {"2,3,6", "1,0,0", "5,1,5"})
    public void stringAddTest(String firstNumber, String secondNumber, Integer expectedResult) {
        Integer actualResult = StringOperation.MULTIPLY.operate(firstNumber, secondNumber);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @DisplayName("나눗셈 계산")
    @ParameterizedTest
    @CsvSource(value = {"6,3,2", "2,1,2", "10,5,2"})
    public void stringAddTest(String firstNumber, String secondNumber, Integer expectedResult) {
        Integer actualResult = StringOperation.DIVIDE.operate(firstNumber, secondNumber);
        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @DisplayName("나눗셈 계산 - 0으로 나누었을 때")
    @ParameterizedTest
    @ValueSource(strings = {"3, 0"})
    public void stringAddTest(String input) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> StringOperation.DIVIDE.operate(input, 0))
                .withMessageMatching("Can not divide by zero.");
    }


}
