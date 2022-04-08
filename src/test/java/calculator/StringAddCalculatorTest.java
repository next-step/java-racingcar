package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringAddCalculatorTest {

  StringAddCalculator stringAddCalculator;

  @BeforeEach
  void setUp() {
    stringAddCalculator = new StringAddCalculator();
  }

  @Test
  @DisplayName("빈 문자열이 들어왔을 경우, 0을 반환")
  void emptyTest() {
    assertThat(stringAddCalculator.calcSum("")).isEqualTo(0);
  }

  @Test
  @DisplayName("null 문자열이 들어왔을 경우, 0을 반환")
  void nullTest() {
    assertThat(stringAddCalculator.calcSum(null)).isEqualTo(0);
  }

  @ParameterizedTest
  @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환")
  @CsvSource(value = {"1,1", "10,10", "120,120", "292150,292150"})
  void onlyNumberTest(String text, int result) {
    assertThat(stringAddCalculator.calcSum(text)).isEqualTo(result);
  }

  @ParameterizedTest
  @DisplayName("콤마, 콜론 구분자를 통해 구분된 숫자의 합을 반환")
  @CsvSource(value = {"1,1|2", "1,2:3|6", "10:1:2|13", "0:0,0|0", "100:100:11|211",
      "2:2,2|6"}, delimiter = '|')
  void addTest(String text, Integer sum) {
    assertThat(stringAddCalculator.calcSum(text)).isEqualTo(sum);
  }


  @ParameterizedTest
  @DisplayName("커스텀 구분자를 통해 구분된 숫자의 합을 반환")
  @MethodSource("customDelimiterParameters")
  void customDelimiterTest(String text, Integer sum) {
    assertThat(stringAddCalculator.calcSum(text)).isEqualTo(sum);
  }

  private static Stream<Arguments> customDelimiterParameters() {
    return Stream.of(
        Arguments.of("//;\n1;2;3", 6),
        Arguments.of("//&&\n1&&2&&7", 10),
        Arguments.of("///\n1/2/3", 6),
        Arguments.of("//!\n1!2!7", 10),
        Arguments.of("//'\n10'20'30", 60)
    );
  }

  @ParameterizedTest
  @DisplayName("음수가 들어왔을 경우, RuntimeException 을 반환")
  @ValueSource(strings = {"1,-1", "-5,-10", "1,2,5,6,-1"})
  void negativeNumberTest(String text) {
    assertThatThrownBy(() -> {
      stringAddCalculator.calcSum(text);
    }).isInstanceOf(RuntimeException.class);
  }

  @ParameterizedTest
  @DisplayName("숫자가 아닌 값이 들어왔을 경우, RuntimeException 을 반환")
  @ValueSource(strings = {"1,-asd1", "zx", "maskld,1k:123", "123mklz,123"})
  void notNumberTest(String text) {
    assertThatThrownBy(() -> {
      stringAddCalculator.calcSum(text);
    }).isInstanceOf(RuntimeException.class);
  }

}
