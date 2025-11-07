package caculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class TokenTest {

  @Test
  void 생성자_숫자_문자열() {
    assertThat(new Token("1").value()).isEqualTo("1");
  }

  @Test
  void 생성자_null_빈문자열() {
    assertThatThrownBy(() -> new Token(null))
        .isInstanceOf(NullPointerException.class)
        .hasMessageContaining("값은 null일 수 없습니다.");
  }

  @ParameterizedTest(name = "생성자_공백_또는_빈_문자열({0})")
  @ValueSource(strings = {"", " "})
  void 생성자_공백_또는_빈_문자열(String input) {
    assertThatThrownBy(() -> new Token(input))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("값은 비어있거나 공백일 수 없습니다.");
  }

  @Test
  void 생성자_숫자가_아닌_문자열() {
    assertThatThrownBy(() -> new Token("a"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("숫자 형식이 아닙니다: a");
  }

  @Test
  void toPositive_양수_문자열() {
    int result = new Token("1").toPositive();

    assertThat(result).isEqualTo(1);
  }

  @Test
  void toPositive_영_문자열() {
    int result = new Token("0").toPositive();

    assertThat(result).isEqualTo(0);
  }

  @Test
  void toPositive_음수_문자열() {
    assertThatThrownBy(new Token("-1")::toPositive)
        .isInstanceOf(RuntimeException.class)
        .hasMessageContaining("음수는 입력할 수 없습니다: -1");
  }
}
