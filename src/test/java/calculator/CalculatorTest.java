package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

  Calculator calculator;

  @BeforeEach
  public void setup() {
    calculator = new StringCalculator();
  }

  @Test
  public void 더하기테스트() {
    assertThat(calculator.calculate("10 + 5")).isEqualTo(15);
    assertThat(calculator.calculate("10 + 5 + 7")).isEqualTo(22);
  }

  @Test
  public void 빼기테스트() {
    assertThat(calculator.calculate("10 - 5")).isEqualTo(5);
    assertThat(calculator.calculate("10 - 5 - 7")).isEqualTo(-2);
  }

  @Test
  public void 곱하기테스트() {
    assertThat(calculator.calculate("10 * 5")).isEqualTo(50);
    assertThat(calculator.calculate("10 * 5 * 2")).isEqualTo(100);
  }

  @Test
  public void 나누기테스트() {
    assertThat(calculator.calculate("10 / 5")).isEqualTo(2);
    assertThat(calculator.calculate("10 / 5 / 2")).isEqualTo(1);
  }

  @Test
  public void 사칙연산혼합테스트() {
    assertThat(calculator.calculate("10 + 5 * 8 - 20 / 4")).isEqualTo(25);
  }

}
