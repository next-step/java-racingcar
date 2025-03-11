import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

  @Test
  void split() {
    String[] result = "1,2".split(",");
    assertThat(result).contains("1");
    assertThat(result).containsExactly("1", "2");
  }

  @Test
  @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환한다.")
  void substring() {
    String input="(1,2)";
    String result = input.substring(input.indexOf("(")+1, input.indexOf(")"));
    assertThat(result).isEqualTo("1,2");
  }

  @Test
  @DisplayName("charAt() 활용 시 인덱스 값이 범위를 벗어나면 StringIndexOutOfBoundsException이 발생한다.")
  void charAt() {
    String input="abc";
    assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
        .isThrownBy(() -> input.charAt(3))
        .withMessageMatching("String index out of range: \\d+");
  }
}
