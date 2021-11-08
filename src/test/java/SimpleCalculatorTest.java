import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SimpleCalculatorTest {

  @Test
  @DisplayName("덧셈 테스트")
  void addition() {
    // given
    String formula = "1 + 2";
    int expected = 3;
    SimpleCalculator calculator = new SimpleCalculator(formula);

    // when
    int result = calculator.calculate();

    // then
    assertEquals(expected, result);
  }

  @Test
  @DisplayName("뺄셈 테스트")
  void subtraction() {
    // given
    String formula = "3 - 1";
    int expected = 2;
    SimpleCalculator calculator = new SimpleCalculator(formula);

    // when
    int result = calculator.calculate();

    // then
    assertEquals(expected, result);
  }

  @Test
  @DisplayName("곱셈 테스트")
  void multiplication() {
    // given
    String formula = "10 * 2";
    int expected = 20;
    SimpleCalculator calculator = new SimpleCalculator(formula);

    // when
    int result = calculator.calculate();

    // then
    assertEquals(expected, result);
  }

  @ParameterizedTest
  @CsvSource(value = {"4 / 2, 2", "5 / 2, 2"})
  @DisplayName("나눗셈 테스트")
  void division(String formula, int expected) {
    SimpleCalculator calculator = new SimpleCalculator(formula);

    // when
    int result = calculator.calculate();

    // then
    assertEquals(expected, result);
  }

  @ParameterizedTest
  @CsvSource(value = {"2 + 3 * 4 / 2, 10", "10 * 1 + 5 / 3, 5"})
  @DisplayName("피연산자가 4개인 수식의 사칙연산기능 테스트")
  void calculateFormulasHasFourOperands(String formula, int expected) {
    // given
    SimpleCalculator calculator = new SimpleCalculator(formula);

    // when
    int result = calculator.calculate();

    // then
    assertEquals(expected, result);
  }

  @ParameterizedTest
  @ValueSource(strings = {"", "  "})
  @DisplayName("수식이 빈 문자열인 경우 예외가 발샘함을 확인하기 위한 테스트")
  void calculateBlankFormula(String formula) {
    // then
    assertThatIllegalArgumentException().isThrownBy(() -> {
      // when
      new SimpleCalculator(formula);
    });
  }

  @ParameterizedTest
  @ValueSource(strings = {"1 # 4", "5 % 2"})
  @DisplayName("수식에 정해진 연산자 외 다른 연산자가 포함되어 있는 경우 예외가 발샘함을 확인하기 위한 테스트")
  void calculateFormulasHasWrongOperands(String formula) {
    // given
    SimpleCalculator calculator = new SimpleCalculator(formula);

    // then
    assertThatIllegalArgumentException().isThrownBy(() -> {
      // when
      calculator.calculate();
    });
  }

}