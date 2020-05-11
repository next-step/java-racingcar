package step1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

  @Test
  void doSplit() {
    String[] data = "1,2".split(",");
    assertThat(data).contains("1");
    assertThat(data).containsExactly("1", "2");
  }

  @Test
  void doSubstring() {
    String data = "(1,2)".substring(1, 4);
    assertThat(data).isEqualTo("1,2");
  }

  @Test
  @DisplayName("특정 위치의 문자 가져오기, 문자열 범위 밖의 위치 탐색 시 익셉션 확인을 위한 테스트")
  void doCharAt() {
    String data = "abc";
    assertThat(data.charAt(0)).isEqualTo('a');
    assertThatThrownBy(() -> {
      data.charAt(data.length());
    }).isInstanceOf(StringIndexOutOfBoundsException.class)
        .hasMessageContaining("String index out of range:");
  }
}
