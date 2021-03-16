package step1;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

  @Test
  void split() {
    String[] result;
    String input = "1,2";
    String input2 = "1";

    result = input.split(",");
    assertThat(result).containsExactly("1","2");

    result = input2.split(",");
    assertThat(result).contains("1");
  }

  @Test
  void subString() {
    String input = "(1,2)";

    String result = input.substring(1,4);
    assertThat(result).isEqualTo("1,2");
  }

  @Test
  @DisplayName("charAt() 동작테스트 및 exception핸들링")
  void charAt() {
    String input = "abc";

    assertThat(input.charAt(0)).isEqualTo('a');

    assertThatThrownBy(() ->
      assertThat(input.charAt(10)).isInstanceOf(StringIndexOutOfBoundsException.class))
        .hasMessageContaining("String index out of range:");
  }
}
