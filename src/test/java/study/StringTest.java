package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

  @DisplayName("split 테스트")
  @Test
  void splitTest() {
    String value = "1,2";
    String[] result = value.split(",");
    assertThat(result).contains("1");
    assertThat(result).containsExactly("1","2");
  }

  @DisplayName("substring 테스트")
  @Test
  void substringTest() {
    String value = "(1,2)";
    int length = value.length();
    String result = value.substring(1,length-1);
    assertThat(result).isEqualTo("1,2");
  }

  @DisplayName("charAt 테스트")
  @Test
  void charAtTest() {
    String value = "abc";
    assertThat(value.charAt(1)).isEqualTo('b');
  }

  @DisplayName("charAt 잘못된 Index 호출시 StringIndexOutOfBoundsException 발생")
  @Test
  void charAtIndexOutOfBoundsExceptionTest() {
    String value = "abc";
    assertThatThrownBy(() -> {
      value.charAt(3);
    }).isInstanceOf(StringIndexOutOfBoundsException.class);
  }

}
