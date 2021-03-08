package study.step2;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ArithmeticTest {

  @ParameterizedTest
  @CsvSource(value = {"+,PLUS", "-,MINUS", "*,MULTIPLICATION", "/,DIVISION"})
  @DisplayName("String -> Arithmetic")
  void findArithmeticByCode(String code, Arithmetic arithmetic) {
    Arithmetic result = Arithmetic.findByCode(code);
    assertEquals(arithmetic, result);
  }

  @Test
  @DisplayName("연산부호가 아닌경우 exception")
  void findArithmeticByCode_fail() {
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> Arithmetic.findByCode("|"))
        .withMessageMatching("Code is not Arithmetic code.");
  }

  @ParameterizedTest
  @CsvSource(value = {"4,5,9", "2,3,5", "4,2,6"})
  @DisplayName("더하기 연산")
  void plus(int firstNumber, int secondNumber, int expected) {
    int result = Arithmetic.PLUS.calculate(firstNumber, secondNumber);
    assertEquals(expected, result);
  }

  @ParameterizedTest
  @CsvSource(value = {"4,3,1", "2,3,-1", "4,2,2"})
  @DisplayName("빼기 연산")
  void minus(int firstNumber, int secondNumber, int expected) {
    int result = Arithmetic.MINUS.calculate(firstNumber, secondNumber);
    assertEquals(expected, result);
  }

  @ParameterizedTest
  @CsvSource(value = {"4,5,20", "2,3,6", "4,2,8"})
  @DisplayName("곱하기 연산")
  void multiplication(int firstNumber, int secondNumber, int expected) {
    int result = Arithmetic.MULTIPLICATION.calculate(firstNumber, secondNumber);
    assertEquals(expected, result);
  }

  @ParameterizedTest
  @CsvSource(value = {"4,5,0", "3,2,1", "4,2,2"})
  @DisplayName("나누기 연산")
  void division(int firstNumber, int secondNumber, int expected) {
    int result = Arithmetic.DIVISION.calculate(firstNumber, secondNumber);
    assertEquals(expected, result);
  }

}
