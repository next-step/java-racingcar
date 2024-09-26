package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
  @Test
  void split() {
    String[] result = "1,2".split(",");
    assertThat(result).containsExactly("1", "2");
  }

  @Test
  void substring() {
    String result = "(1,2)".substring(1, 4);
    assertThat(result).isEqualTo("1,2");
  }

  @DisplayName("Find a character with specific location")
  @Test
  void charAt() {
    Character result = "abc".charAt(1);
    assertThat(result).isEqualTo('b');
  }

  @DisplayName("Invalid index throws IndexOutOfBoundsException")
  @Test
  void charAtException() {
    assertThatExceptionOfType(IndexOutOfBoundsException.class)
        .isThrownBy(() -> {
          "abc".charAt(5);
        }).withMessageMatching("String index out of range: 5");
  }

}
