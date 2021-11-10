package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

  @Test
  public void add() {
    Calculator calculator = new Calculator("1 + 2");
    assertThat(calculator.calculate()).isEqualTo(3);
  }

  @Test
  public void subtract() {
    Calculator calculator = new Calculator("1 - 2");
    assertThat(calculator.calculate()).isEqualTo(-1);
  }

  @Test
  public void multiple() {
    Calculator calculator = new Calculator("1 * 2");
    assertThat(calculator.calculate()).isEqualTo(2);
  }

  @Test
  public void divide() {
    Calculator calculator = new Calculator("1 / 2");
    assertThat(calculator.calculate()).isEqualTo(0);
  }

  @Test
  public void multipleOperation() {
    Calculator calculator = new Calculator("1 * 2 / 2 + 1 - 2");
    assertThat(calculator.calculate()).isEqualTo(0);
  }

  @Test
  public void throwNumberFormatException() {
    assertThatExceptionOfType(NumberFormatException.class)
        .isThrownBy(() -> new Calculator(". * 2 / 2 + 1 - 2").calculate());
  }

  @Test
  public void throwIllegalArgumentException() {
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> new Calculator("1 * 2 / 0 + 1 - 2").calculate());
  }
}
