package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

  @Test
  @DisplayName("요구사항 1 split")
  void split() {
    String[] result = getArrays("1,2", ",");
    assertThat(result).contains("1");
    assertThat(result).contains("1", "2");
    assertThat(result).containsExactly("1", "2");
  }

  @Test
  @DisplayName("요구사항 2 substring")
  void substring() {
    String str = "(1,2)";
    String result = str.substring(1, str.length() - 1);
    assertThat(getArrays(result, ",")).containsExactly("1", "2");
  }

  private String[] getArrays(String str, String separator) {
    return str.split(separator);
  }

  @Test
  @DisplayName("요구사항 3 charAt")
  void charAt() {
    String str = "abc";
    assertThat(getChar(str, 0)).isEqualTo('a');
    assertThat(getChar(str, 1)).isEqualTo('b');
    assertThat(getChar(str, 2)).isEqualTo('c');
  }

  @Test
  @DisplayName("요구사항 3 charAt exception test")
  void charAtOfThrow() {
    String str = "abc";
    assertThatThrownBy(() -> getChar(str, 3))
            .isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessageContaining("String index out of range");

    assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
            .isThrownBy(() -> getChar(str, 3))
            .withMessageMatching("String index out of range: \\d+");
  }

  private char getChar(String str, int i) {
    return str.charAt(i);
  }
}
