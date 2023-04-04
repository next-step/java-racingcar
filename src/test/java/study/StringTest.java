package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

  @DisplayName("split을 사용하여 문자열을 나눈다.")
  @Test
  void requirement1() {
    String[] result = "1,2".split(",");
    assertThat(result).containsExactly("1", "2");

    result = "1".split(",");
    assertThat(result).contains("1");
  }

  @DisplayName("substring을 사용하여 특정 문자열을 잘라낸다.")
  @Test
  void requirement2() {
    String result = "(1,2)".substring(1, 4);

    assertThat(result).isEqualTo("1,2");
  }

  @DisplayName("charAt을 사용하여 문자열 길이 범위 내 인덱스를 인자로 전달하여 특정 위치 문자를 가져온다.")
  @Test
  void requirement3_1() {
    String result = "abc";

    assertThat(result.charAt(0)).isEqualTo('a');
    assertThat(result.charAt(1)).isEqualTo('b');
    assertThat(result.charAt(2)).isEqualTo('c');
  }

  @DisplayName("charAt 사용시 문자열 길이 범위를 넘는 인덱스를 인자로 전달하면 StringIndexOutOfBoundsException이 발생한다.")
  @Test
  void requirement3_2() {
    String result = "abc";

    assertThatThrownBy(() -> {
      result.charAt(3);
    }).isInstanceOf(StringIndexOutOfBoundsException.class)
        .hasMessageContaining("String index out of range: " + 3);

    assertThatThrownBy(() -> {
      result.charAt(-1);
    }).isInstanceOf(StringIndexOutOfBoundsException.class)
        .hasMessageContaining("String index out of range: " + -1);
  }

}
