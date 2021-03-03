package stringCalculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class calculatorTest {

  private Calculator calculator;

  @BeforeEach
  void setUp() {
    calculator = new Calculator();
  }

  @DisplayName("덧셈,뺄셈,곱셈,나눗셈 테스트")
  @ParameterizedTest
  @CsvSource(value = {
      "1 + 2:3", "2 + 3:5", "3 + 4:7", "6 + 8:14", "12 + 15:27",
      "7 - 2:5", "1 - 3:-2", "10 - 7:3", "19 - 5:14", "6 - 7:-1",
      "1 * 2:2", "3 * 4:12", "5 * 9:45", "4 * 7:28", "7 * 8:56",
      "10 / 2:5", "22 / 2:11", "6 / 3:2", "15 / 3:5", "20 / 5:4"
  }, delimiter = ':')
  void calculate(String input, String expected) {
    int result = calculator.calculate(input);
    assertThat(result).isEqualTo(Integer.parseInt(expected));
  }

}
