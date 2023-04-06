package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringSplitTest {

  @Test
  @DisplayName("contains & containsExactly")
  void split() {
    // given
    String input = "1,2";

    // when
    String[] result = input.split(",");

    // then
    assertThat(result).containsExactly("1", "2");
    assertThat(result).contains("1", "2");
  }

  @Test
  @DisplayName("containsExactly")
  void split2() {
    // given
    String input = "1";

    // when
    String[] result = input.split(",");

    // then
    assertThat(result).containsExactly("1");
  }


  @Test
  @DisplayName("substring")
  void substring() {
    // given
    String input = "(1,2)";

    // when
    String result = input.substring(1, input.length() - 1);

    // then
    assertThat(result).isEqualTo("1,2");
  }

  @Test
  @DisplayName("특정 index 위치 값 올바르게 가져오는지 확인")
  void charAt() {
    // given
    String input = "abc";

    // when
    char result = input.charAt(1);

    // then
    assertEquals(result, 'b');
  }

  @Test
  @DisplayName("index 위치를 벗어나는 경우, exception 발생 - assertThrows")
  void charAtException() {
    // given
    String input = "abc";

    // when & then
    assertThrows(StringIndexOutOfBoundsException.class, () -> input.charAt(3));
  }

  @Test
  @DisplayName("index 위치를 벗어나는 경우, exception 발생 - assertThatThrownBy.")
  void charAtException2() {
    // given
    String input = "abc";

    // when & then
    assertThatThrownBy(() -> input.charAt(3))
        .isInstanceOf(StringIndexOutOfBoundsException.class)
        .hasMessageContaining("String index out of range: 3");
  }

  @Test
  @DisplayName("index 위치를 벗어나는 경우, exception 발생 - assertThatExceptionOfType")
  void charAtException3() {
    // given
    String input = "abc";

    // when & then
    assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
        .isThrownBy(() -> input.charAt(3))
        .withMessageMatching("String index out of range: 3");
  }

}
