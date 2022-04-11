import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringTest {

  @Test
  void splitTwo() {
    assertThat("1,2".split(",")).containsExactly("1", "2");
  }

  @Test
  void splitOnlyOne() {
    assertThat("1".split(",")).containsExactly("1");
  }

  @Test
  void substring() {
    assertThat("(1,2)".substring(1, 4)).isEqualTo("1,2");
  }

  @DisplayName("charAt으로 특정 위치의 문자를 가져온다.")
  @Test
  void charAt() {
    String target = "abc";
    assertThat(target.charAt(0)).isEqualTo('a');
    assertThat(target.charAt(1)).isEqualTo('b');
    assertThat(target.charAt(2)).isEqualTo('c');
  }

  @DisplayName("charAt 사용 시, index를 벗어나면 StringIndexOutOfBoundsException이 발생한다.")
  @Test
  void charAtException() {
    String target = "abc";

    assertThatThrownBy(() -> {
      target.charAt(4);
    }).isInstanceOf(StringIndexOutOfBoundsException.class)
        .hasMessageContaining("range: 4");

    assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> {
      target.charAt(5);
    }).withMessageMatching("[^0-9]+range: \\d+");
  }
}
