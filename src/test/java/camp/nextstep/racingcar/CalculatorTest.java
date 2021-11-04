package camp.nextstep.racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
  private Calculator calculator;

  @BeforeEach
  void setUp() {
    calculator = new Calculator();
  }

  @ParameterizedTest
  @CsvSource( {"1,2,3", "0,0,0", "2,-1,1", "-2,-1,-3"})
  void testCalculatorAdd(int a, int b, int expected) {
    assertThat(Calculator.add(a, b)).isEqualTo(expected);
  }

  @ParameterizedTest
  @CsvSource( {"1,2,-1", "0,0,0", "2,1,1", "-2,-1,-1"})
  void testCalculatorSubtract(int a, int b, int expected) {
    assertThat(Calculator.subtract(a, b)).isEqualTo(expected);
  }

  @ParameterizedTest
  @CsvSource( {"1,2,2", "0,0,0", "-2,1,-2", "-2,-1,2"})
  void testCalculatorMultiply(int a, int b, int expected) {
    assertThat(Calculator.multiply(a, b)).isEqualTo(expected);
  }

  @ParameterizedTest
  @CsvSource( {"9,3,3", "-4,2,-2", "-6,-3,2"})
  void testCalculatorDivide(int a, int b, int expected) {
    assertThat(Calculator.divide(a, b)).isEqualTo(expected);
  }

  @ParameterizedTest
  @NullSource
  @EmptySource
  @ValueSource(strings = {"1 @ 2", ""})
  void testTokenizerIllegalInput(String illegalInput) {
    assertThatThrownBy(() -> {
      calculator.tokenizer(illegalInput);
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void testTokenizer() {
    assertThat(calculator.tokenizer("1")).hasSize(1).contains("1");
    assertThat(calculator.tokenizer("1 + 2")).hasSize(3).contains("1", "+", "2");
    assertThat(calculator.tokenizer("1 + 2 / 3 * 4")).hasSize(7).contains("1", "+", "2", "/", "3", "*", "4");
  }

  @Test
  void testCalculate() {
    assertThat(calculator.calculate("1")).isEqualTo(1);
    assertThat(calculator.calculate("1 + 2")).isEqualTo(3);
    assertThat(calculator.calculate("1 + 2 / 3 * 4")).isEqualTo(4);
  }
}

