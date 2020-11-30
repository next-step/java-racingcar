package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

  @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인")
  @Test
  void splitComma() {
    String input = "1,2";
    String[] result = input.split(",");
    assertThat(result).containsExactly("1", "2");
  }

  @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환 되는지 확인")
  @Test
  void splitCommaOnly() {
    String input = "1";
    String[] result = input.split(",");
    assertThat(result).containsExactly(input);
  }

  @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환")
  @Test
  void substring() {
    String input = "(1,2)";
    String result = input.substring(1,4);
    assertThat(result).isEqualTo("1,2");
  }

  @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자 반환")
  @Test
  void charAt() {
    String input = "abc";
    char[] inputCharArr = input.toCharArray();
    for (int i = 0; i < inputCharArr.length; i++) {
      assertThat(input.charAt(i)).isEqualTo(inputCharArr[i]);
    }
  }

  @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나 exception 반환")
  @Test
  void charAtExceptionCase() {
    String input = "abc";
    assertThatThrownBy(() -> {
      input.charAt(input.length());
    }).isInstanceOf(StringIndexOutOfBoundsException.class);
  }
}
