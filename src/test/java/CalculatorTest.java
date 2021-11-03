import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
  private Calculator calculator;

  @BeforeEach
  void setUp() {
    calculator = new Calculator();
  }

  @ParameterizedTest
  @CsvSource({"1,2,3", "0,0,0", "2,-1,1", "-2,-1,-3"})
  public void testAdd(int a, int b, int expected) {
    assertThat(calculator.add(a, b)).isEqualTo(expected);
  }

  @ParameterizedTest
  @CsvSource({"1,2,-1", "0,0,0", "2,1,1", "-2,-1,-1"})
  public void testSubtract(int a, int b, int expected) {
    assertThat(calculator.subtract(a, b)).isEqualTo(expected);
  }

  @ParameterizedTest
  @CsvSource({"1,2,2", "0,0,0", "-2,1,-2", "-2,-1,2"})
  public void testMultiply(int a, int b, int expected) {
    assertThat(calculator.multiply(a, b)).isEqualTo(expected);
  }

  @ParameterizedTest
  @CsvSource({"9,3,3", "-4,2,-2", "-6,-3,2"})
  public void testDevide(int a, int b, int expected) {
    assertThat(calculator.devide(a, b)).isEqualTo(expected);
  }

  @ParameterizedTest
  @NullSource
  @EmptySource
  @ValueSource(strings = {"1 @ 2", ""})
  public void testTokeninzerIlligalInput(String illigalInput) {
    assertThatThrownBy(() -> {
      calculator.tokenizer(illigalInput);
    }).isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  public void testTokenizer() {
    assertThat(calculator.tokenizer("1")).hasSize(1).contains("1");
    assertThat(calculator.tokenizer("1 + 2")).hasSize(3).contains("1", "+", "2");
    assertThat(calculator.tokenizer("1 + 2 / 3 * 4")).hasSize(7).contains("1", "+", "2", "/", "3", "*", "4");
  }

  @Test
  public void testCalculate() {
    ArrayList<String> input1 = new ArrayList<String>(Arrays.asList("1"));
    assertThat(calculator.calculate(input1)).isEqualTo(1);
    ArrayList<String> input2 = new ArrayList<String>(Arrays.asList("1", "+", "2"));
    assertThat(calculator.calculate(input2)).isEqualTo(3);
    ArrayList<String> input3 = new ArrayList<String>(Arrays.asList("1", "+", "2", "/", "3", "*", "4"));
    assertThat(calculator.calculate(input3)).isEqualTo(4);
  }
}

