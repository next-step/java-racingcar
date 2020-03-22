package step2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {

  private Calculator calculator = new Calculator();

  @Test
  public void testNull() {
    assertThatThrownBy(() -> calculator.calculate(null))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void testDivideByZeory() {
    assertThatThrownBy(() -> calculator.calculate("3 / 0"))
        .isInstanceOf(ArithmeticException.class);
  }

  @ParameterizedTest
  @ValueSource(strings = {"", "  ", "3& 4", "3 & 4", "3& ! 4", "- 3 + 4", "3 + 4 5"})
  public void testIllegalArgument(String input) {
    assertThatThrownBy(() -> calculator.calculate(input))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @ParameterizedTest
  @CsvSource(value = {"3 + 4=7", "3 - 4=-1", "3 * 4=12", "3 / 4=0", "3 * 4 / 2 + 7 / 3=4"}, delimiter = '=')
  public void testCalculate(String formula, String result) {
    assertThat(calculator.calculate(formula)).isEqualTo(Integer.parseInt(result));
  }
}
