package basic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

  @Test
  void 요구사항1() {
    String[] result1 = "1,2".split(",");
    assertThat(result1).contains("1");

    String[] result2 = "1".split(",");
    assertThat(result2).containsExactly("1");
  }

  @Test
  void 요구사항2() {
    String data = "(1,2)";
    String testData = data.substring(data.indexOf("(") + 1, data.indexOf(")"));
    assertThat(testData).isEqualTo("1,2");
  }

  @Test
  @DisplayName("charAt()_IndexOutOfBoundsException 발생 테스트 입니다.")
  void 요구사항3() {
    String data = "abc";

    assertThatThrownBy(() -> data.charAt(4))
        .isInstanceOf(IndexOutOfBoundsException.class)
        .hasMessageMatching("String index out of range: \\d+");
  }

}
