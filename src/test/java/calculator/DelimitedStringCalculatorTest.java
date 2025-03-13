package calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DelimitedStringCalculatorTest {

  @DisplayName("빈 문자열이 주어졌을 때 sum()을 호출하면 0을 반환한다.")
  @Test
  void sum_emptyString_returnsZero() {
    String input = "";

    int result = DelimitedStringCalculator.sum(input);

    assertThat(result).isEqualTo(0);
  }

  @DisplayName("null이 주어졌을 때 sum()을 호출하면 0을 반환한다.")
  @Test
  void sum_null_returnZero(){
    String input = null;

    int result = DelimitedStringCalculator.sum(input);

    assertThat(result).isEqualTo(0);
  }

  @DisplayName("구분자가 없이 숫자 하나만 있는 문자열이 주어졌을 때 sum()을 호출하면 입력된 수 그대로 반환한다.")
  @Test
  void sum_singleNumberString_returnsSameNumber() {
    String input = "1";

    int result = DelimitedStringCalculator.sum(input);

    assertThat(result).isEqualTo(1);
  }

  @DisplayName("\",\"로 구분되는 문자열이 주어졌을 때 sum()을 호출하면 수의 합을 반환한다.")
  @Test
  void sum_commaSeparatedString_returnsSumOfNumbers() {
    String input = "1,2,3";

    int result = DelimitedStringCalculator.sum(input);

    assertThat(result).isEqualTo(6);
  }

  @DisplayName("\":\"로 구분되는 문자열이 주어졌을 때 sum()을 호출하면 수의 합을 반환한다.")
  @Test
  void sum_colonSeparatedString_returnsSumOfNumbers() {
    String input = "1:2:3";

    int result = DelimitedStringCalculator.sum(input);

    assertThat(result).isEqualTo(6);
  }

  @DisplayName("커스컴 구분자를 가지는 형식의 문자열이 주어졌을 때 sum()을 호출하면 수의 합을 반환한다.")
  @Test
  void sum_customDelimiterString_returnsSumOfNumbers() {
    String input = "//;\n1;2;3";

    int result = DelimitedStringCalculator.sum(input);

    assertThat(result).isEqualTo(6);
  }


  @DisplayName("커스텀 구분자를 입력받은 형태가 아닌데 \",\" 혹은 \":\" 구분자가 아닌 문자열이 주어졌을 떄 sum()을 호출하면 IllegalArgumentException을 던진다.")
  @Test
  void sum_invalidDelimiter_throwsIllegalArgumentException() {
    String input = "1$2";

    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> DelimitedStringCalculator.sum("1$2")
    );
  }

  @DisplayName("음수를 가지는 형식의 문자열이 주어졌을 때 sum()을 호출하면 RuntimeException을 던진다.")
  @Test
  void sum_withNegativeValue_throwsException() {
    String input "-1:2";

    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> DelimitedStringCalculator.sum("1$2")
    );
  }
}
