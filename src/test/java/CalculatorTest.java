import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {

  @ParameterizedTest
  @ValueSource(strings = {"1+2+3+4+5", "+ + 3 4", "1 2 3 4", "2 + 3 ++ 4", "2 + 3 . 4"})
  @DisplayName("올바르지 않은 계산식이 입력될 때 예외가 발생하는가")
  public void isThrowExceptionNonValidateFormula(String userInput) {

    //given
    Calculator calculator = new Calculator();

    //when
    IllegalArgumentException thrown = assertThrows(
        IllegalArgumentException.class,
        () -> calculator.enterFormula(userInput)
    );

    //then
    assertTrue(thrown.getMessage().contains("ERROR"));
  }

  @ParameterizedTest
  @CsvSource({"100 * 100 / 100 - 100 + 1, 1",
              "2 + 3 * 4 / 2, 10",
              "3 * 10 - 10, 20",
              "3 / 9, 0"})
  @DisplayName("계산 결과가 올바른가")
  public void isCorrectCalculateResult(String formula, int actualAnswer) {
    //given
    Calculator calculator = new Calculator();

    //when
    calculator.enterFormula(formula);
    int expectedAnswer = calculator.calculate();

    //then
    assertEquals(expectedAnswer, actualAnswer);
  }

  @Test
  @DisplayName("0으로 나누었을 때 익셉션이 발생하는가")
  public void isThrowExceptionDivideZero() {
    //given
    Calculator calculator = new Calculator();

    //when
    calculator.enterFormula("1 / 0");

    ArithmeticException thrown = assertThrows(
        ArithmeticException.class,
        () -> calculator.calculate()
    );

    //then
    assertTrue(thrown.getMessage().contains("by zero"));
  }
}