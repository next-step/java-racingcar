package caculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class PositiveOrZeroTest {

  @Test
  void 생성자_양수() {
    assertThat(new PositiveOrZero(1).value()).isEqualTo(1);
  }

  @Test
  void 생성자_음수() {
    assertThatThrownBy(() -> new PositiveOrZero(-1))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("음수는 입력할 수 없습니다: -1");
  }

  @Test
  void from_양수_문자열() {
    assertThat(PositiveOrZero.from("1").value()).isEqualTo(1);
  }

  @Test
  void from_음수_문자열() {
    assertThatThrownBy(() -> PositiveOrZero.from("-1"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("음수는 입력할 수 없습니다: -1");
  }

  @Test
  void from_null() {
    assertThatThrownBy(() -> PositiveOrZero.from(null))
        .isInstanceOf(NullPointerException.class)
        .hasMessageContaining("값은 null일 수 없습니다.");
  }

  @ParameterizedTest(name = "생성자_공백_또는_빈_문자열({0})")
  @ValueSource(strings = {"", " "})
  void from_공백_또는_빈_문자열(String input) {
    assertThatThrownBy(() -> PositiveOrZero.from(input))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("값은 비어있거나 공백일 수 없습니다.");
  }

  @Test
  void from_숫자가_아닌_문자열() {
    assertThatThrownBy(() -> PositiveOrZero.from("a"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("숫자 형식이 아닙니다: a");
  }
}
