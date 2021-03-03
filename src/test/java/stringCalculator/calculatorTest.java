package stringCalculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class calculatorTest {

  @DisplayName("덧셈 테스트")
  @ParameterizedTest
  @CsvSource(value = {"1,2:3", "2,3:5", "3,4:7", "6,8:14", "12,15:27"}, delimiter = ':')
  void plus(String input, String expected) {
    Calculator calculator = new Calculator();
    String[] inputNumbers = input.split(",");
    int result = calculator.plus(Integer.parseInt(inputNumbers[0]), Integer.parseInt(inputNumbers[1]));
    assertThat(result).isEqualTo(Integer.parseInt(expected));
  }

  @DisplayName("뺄셈 테스트")
  @ParameterizedTest
  @CsvSource(value = {"7,2:5", "1,3:-2", "10,7:3", "19,5:14", "6,7:-1"}, delimiter = ':')
  void subtract(String input, String expected) {
    Calculator calculator = new Calculator();
    String[] inputNumbers = input.split(",");
    int result = calculator.subtract(Integer.parseInt(inputNumbers[0]), Integer.parseInt(inputNumbers[1]));
    assertThat(result).isEqualTo(Integer.parseInt(expected));
  }

}
