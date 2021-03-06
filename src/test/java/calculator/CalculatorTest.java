package calculator;

import org.assertj.core.util.Strings;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CalculatorTest {
  private StringCalculator stringCalculator = new StringCalculator();

  @ParameterizedTest
  @DisplayName("더하기 테스트")
  @CsvSource(value = {"1 + 2:3", "3 + 4:7", "1 + 5:6"}, delimiter = ':')
  void plusRightAnswerTest(String formula, int answer){
    assertThat(stringCalculator.calculate(formula)).isEqualTo(answer);
  }

  @ParameterizedTest
  @DisplayName("빼기 테스트")
  @CsvSource(value={"2 - 1:1", "3 - 4:-1", "5 - 2:3"}, delimiter = ':')
  void minusRightAnswerTest(String formula, int answer){
    assertThat(stringCalculator.calculate(formula)).isEqualTo(answer);
  }

  @ParameterizedTest
  @DisplayName("곱하기 테스트")
  @CsvSource(value = {"2 * 1:2", "3 * 4:12", "5 * 2:10", "6 * -1:-6" }, delimiter = ':')
  void multipleRightAnswerTest(String formula, int answer){
    assertThat(stringCalculator.calculate(formula)).isEqualTo(answer);
  }

  @ParameterizedTest
  @DisplayName("나누기 테스트(나누는 값은 정수로 떨어져야 함)")
  @CsvSource(value={"2 / 1:2", "9 / 3:3", "-4 / 2:-2", "2 / -1:-2"}, delimiter = ':')
  void divideRightAnswerTest(String formula, int answer){
    assertThat(stringCalculator.calculate(formula)).isEqualTo(answer);
  }

  @ParameterizedTest
  @DisplayName("정확한 결과를 도출하는 지 테스트")
  @ValueSource(strings = "11 * 5 + 2 * 10")
  void rightAnswerTest(String formula){
    assertThat(stringCalculator.calculate(formula)).isEqualTo(570);
  }

  @ParameterizedTest
  @DisplayName("비어있는 수식 체크")
  @ValueSource(strings = {"", " ", "   "})
  void emptyFormulaTest(String formula){
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> {
      stringCalculator.calculate(formula);
        }).withMessageMatching("Target String is empty.");
  }

  @ParameterizedTest
  @DisplayName("사칙연산이 아닐 경우 에러 체크")
  @ValueSource(strings = {"1 & 2", "3 ^ 2", "1 ' 2"})
  void wrongInputOperatorTest(String formula){
    assertThatExceptionOfType(IllegalArgumentException.class)
        .isThrownBy(() -> {
      stringCalculator.calculate(formula);
        }).withMessageMatching("Operator Error");
  }

  @ParameterizedTest
  @DisplayName("잘못된 순서, 즉 1 2 * 등의 입력값이 주어졌을 때 숫자를 변환할 수 없는 에러 테스트")
  @ValueSource(strings = {"1 2 *"})
  void wrongInputOperandTest(String formula){
    assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(()->{
      stringCalculator.calculate(formula);
    }).withMessageMatching("Can not convert to Integer");
  }
}
