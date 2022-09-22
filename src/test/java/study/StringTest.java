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
  void splitSingleString() {
    String[] result = "1".split(",");
    assertThat(result).containsExactly("1");
  }

  @Test
  void removeBracket() {
    String result = "(1,2)".substring(1, 4);
    assertThat(result).isEqualTo("1,2");
  }

  @DisplayName("Gets certain order of characters")
  @Test
  void pickCharAt() {
    char result = "abc".charAt(1);
    assertThat(result).isEqualTo('b');
  }

  @DisplayName("throws exception when try to get out of range character")
  @Test
  void tryOutOfRangeCharAt() {
    String string = "abc";
    int lastIdx = string.length() + 1;

    assertThatExceptionOfType(IndexOutOfBoundsException.class)
        .isThrownBy(() ->{
          string.charAt(lastIdx);
        }).withMessageContaining("String index out of range: %d", lastIdx);
  }
}
