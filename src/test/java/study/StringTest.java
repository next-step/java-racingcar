package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("String 클래스에 대한 학습 테스트")
public class StringTest {

  @DisplayName("쉼표를 구분자로 split했을 때 올바르게 분리된다")
  @Test
  void splitByComma() {
    String[] result = "1,2".split(",");

    assertThat(result).containsExactly("1", "2");
  }

  @DisplayName("구분자가 없는 문자열을 split했을 때 하나의 요소만 반환한다")
  @Test
  void splitWithoutComma() {
    String[] result = "1".split(",");

    assertThat(result).containsExactly("1");
  }

  @DisplayName("substring으로 괄호를 제거하면 내부 문자열만 반환한다")
  @Test
  void removesParentheses() {
    String input = "(1,2)";

    String result = input.substring(1, input.length() - 1);

    assertThat(result).isEqualTo("1,2");
  }
}
