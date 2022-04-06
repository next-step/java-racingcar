import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class StringCalculatorTest {

  private StringCalculator calculator;

  @BeforeEach
  private void init() {
    calculator = new StringCalculator();
  }

  @Test
  @DisplayName("빈 문자열 또는 null값을 입력할 경우 0을 반환해야 한다.")
  void zeroReturn() {
    int expect = 0;
    assertThat(calculator.calculate("")).isEqualTo(expect);
    assertThat(calculator.calculate(null)).isEqualTo(expect);
  }

  @ParameterizedTest
  @DisplayName("숫자 하나를 문자열로 입력하는 경우 해당 숫자를 반환한다.")
  @ValueSource(strings = {"1", "2", "3", "4", "5", "6", "7", "8", "9"})
  void oneNumber(String number) {
    int expect = Integer.parseInt(number);
    assertThat(calculator.calculate(number)).isEqualTo(expect);
  }

  @ParameterizedTest
  @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다.")
  @CsvSource(value = {"1,2:3","2,5:7","3,6:9","4,10:14"},delimiter = ':')
  void numberSum(String input, String expect) {
    int actual = Integer.parseInt(expect);
    assertThat(calculator.calculate(input)).isEqualTo(actual);
  }

  @ParameterizedTest
  @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다.")
  @CsvSource(value = {"1:2$3","2,3:5$10","1,1,2:20$24"},delimiter = '$')
  void columnTest(String input, String expect) {
    int actual = Integer.parseInt(expect);
    assertThat(calculator.calculate(input)).isEqualTo(actual);
  }
}