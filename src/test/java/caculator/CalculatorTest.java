package caculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class CalculatorTest {

  private Calculator calculator;

  @BeforeEach
  void setUp() {
    calculator = new Calculator();
  }

  @ParameterizedTest
  @NullAndEmptySource
  public void splitAndSum_null_또는_빈문자(String text) {
    int result = calculator.calculate(text);
    assertThat(result).isEqualTo(0);
  }

  @ParameterizedTest(name = "splitAndSum_{0}")
  @CsvSource(value = {"1|1", "1,2|3", "1,2:3|6", "'//;\n1;2;3'|6"}, delimiter = '|')
  public void splitAndSum(String input, Integer expected) throws Exception {

    int result = calculator.calculate(input);
    assertThat(result).isEqualTo(expected);
  }

  @Test
  public void splitAndSum_negative() throws Exception {
    assertThatThrownBy(() -> calculator.calculate("-1,2,3"))
        .isInstanceOf(IllegalArgumentException.class);
  }
}
