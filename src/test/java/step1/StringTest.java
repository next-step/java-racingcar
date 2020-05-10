package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

  @Test
  void requirement01 () {
    String[] result = "1,2".split(",");
    assertThat(result).contains("1", "2");
  }

  @Test
  void requirement02 () {
    String input = "(1,2)";
    String result = input.substring(1, input.length() - 1);
    assertThat(result).contains("1,2");
  }

  //@DisplayName("String.charAt(n) 에서 n이 String의 범위를 벗어나는 경우 StringIndexOutOfBoundsException 발생")
  @Test
  void requirement03 () {
    String input = "abc";
    System.out.println(input);
    //assertThat(input.charAt(0)).isEqualTo('a');
//    assertThat(input.charAt(1)).isEqualTo('b');
//    assertThat(input.charAt(2)).isEqualTo('c');

//    assertThatThrownBy(() -> {
//      input.charAt(3);
//    }).isInstanceOf(StringIndexOutOfBoundsException.class)
//      .hasMessageContaining("index -1은 abc의 범위에 해당되지 않습니다.");
//
//    assertThatThrownBy(() -> {
//      input.charAt(-1);
//    }).isInstanceOf(StringIndexOutOfBoundsException.class)
//      .hasMessageContaining("index -1은 abc의 범위를 벗어납니다.");
  }
}
