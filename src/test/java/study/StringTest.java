package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

  @Test
  void split() {
    String[] result1 = "1,2".split(",");
    String[] result2 = "1".split(",");

    assertThat(result1).containsExactly("1", "2");
    assertThat(result2).contains("1");
  }

  @Test
  void subString() {
    String result = "(1,2)".substring(1,4);

    assertThat(result).isEqualTo("1,2");
  }

  @Test
  @DisplayName("특정 위치의 문자를 가져올 때 위치 값이 벗어날 경우 StringIndexOutOfBoundsException 발생")
  void charAt() {
    String data = "abc";
    assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
        .isThrownBy(() -> data.charAt(5));
  }

}