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
  void 생성자_null() {
    assertThatThrownBy(() -> new Token(null))
        .isInstanceOf(NullPointerException.class)
        .hasMessageContaining("값이 null입니다.");
  }

  @ParameterizedTest(name = "생성자_공백_문자열({0})")
  @ValueSource(strings = {"", " "})
  void 생성자_공백_문자열(String input) {
    assertThatThrownBy(() -> new Token(input))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("값이 비어있거나 공백입니다.");
  }

  @Test
  void 생성자_숫자가_아닌_문자열() {
    assertThatThrownBy(() -> new Token("a"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("숫자가 아닙니다: a");
  }

  @Test
  void of_숫자_문자열() {
    assertThat(Token.of("1").value()).isEqualTo("1");
  }

  @Test
  void of_Null() {
    assertThatThrownBy(() -> Token.of(null)).isInstanceOf(NullPointerException.class);
  }

  @ParameterizedTest(name = "공백 입력({0})일 때 예외 발생")
  @ValueSource(strings = {"", " "})
  void of_공백_문자열(String input) {
    assertThatThrownBy(() -> Token.of(input))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("값이 비어있거나 공백입니다.");
  }

  @Test
  void of_숫자가아닌_문자열() {
    assertThatThrownBy(() -> Token.of("a"))
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining("숫자가 아닙니다: a");
  }

  @Test
  void toPositive_양수_문자열() {
    int result = Token.of("1").toPositive();

    assertThat(result).isEqualTo(1);
  }

  @Test
  void toPositive_영_문자열() {
    int result = Token.of("0").toPositive();

    assertThat(result).isEqualTo(0);
  }

  @Test
  void toPositive_음수_문자열() {
    assertThatThrownBy(Token.of("-1")::toPositive)
        .isInstanceOf(RuntimeException.class)
        .hasMessageContaining("음수를 입력할 수 없습니다: -1");
  }
}
