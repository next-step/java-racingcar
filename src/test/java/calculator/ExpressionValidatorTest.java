package calculator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class ExpressionValidatorTest {

  @ParameterizedTest
  @NullSource
  @EmptySource
  @DisplayName("빈 expression은 예외를 발생시킨다.")
  public void emptyTest(String source) {
    assertThatThrownBy(() -> ExpressionValidator.validate(source))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @ParameterizedTest
  @ValueSource(strings = {"1 + + + 1", "1 + + 1"})
  @DisplayName("수식은 숫자와 문자열이 연속되게 입력될 수 없다.")
  public void isRepeatNumberAndOperator(String source) {
    assertThatThrownBy(() -> ExpressionValidator.validate(source))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("수식의 시작과 숫자이다.")
  public void isNumberStart() {
    assertThatThrownBy(() -> ExpressionValidator.validate("+ 1 + 1"))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("수식의 끝은 숫자이다")
  public void isNumberEnd() {
    assertThatThrownBy(() -> ExpressionValidator.validate("1 + 1 +"))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("1 은 수식이다")
  public void oneElement() {
    assertDoesNotThrow(() -> ExpressionValidator.validate("1"));
  }

  @Test
  @DisplayName("-1 - -1 - -1 - -1 은 수식이다.")
  public void complicateMinus() {
    assertDoesNotThrow(() -> ExpressionValidator.validate("-1 - -1 - -1 - -1"));
  }
}