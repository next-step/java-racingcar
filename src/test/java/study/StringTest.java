package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {

  @Test
  @DisplayName("split 테스트")
  void split() {
    String[] result = "1,2".split(",");

    assertThat(result).contains("1");
    assertThat(result).containsExactly("1", "2");
  }

  @Test
  @DisplayName("substring 테스트")
  void substring() {
    String result = "(1,2)".substring(1, 4);

    assertThat(result).contains("1,2");
  }

  @Test
  @DisplayName("charAt을 활용해 특정 위치의 문자를 가져올 때, 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 테스트")
  void charAt() {
    String given = "abc";
    int index = -1;

    assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> {
      given.charAt(index);
    }).withMessageMatching("String index out of range: " + index);
  }

}
