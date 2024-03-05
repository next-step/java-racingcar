package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

  @Test
  void splitComma(){
    String[] result = "1,2".split(",");
    assertThat(result).containsExactly("1", "2");
  }

  @Test
  void splitCommaOne(){
    String[] result = "1".split(",");
    assertThat(result).containsExactly("1");
  }

  @Test
  @DisplayName("String.substring를 사용해 괄호를 제거하는지 확인")
  void substring(){
    // given
    String input = "(1,2)";

    // when
    String result = input.substring(1, input.length() - 1);

    // then
    assertThat(result).isEqualTo("1,2");
  }

  @Test
  @DisplayName("String.charAt를 사용해 특정 위치의 문자를 가져오는지 확인")
  void charAt(){
    // given
    String input = "abc";

    assertThat(input.charAt(0)).isEqualTo('a');
    assertThat(input.charAt(1)).isEqualTo('b');
    assertThat(input.charAt(2)).isEqualTo('c');

    assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
    .isThrownBy(() -> { input.charAt(3);});
  }

}
