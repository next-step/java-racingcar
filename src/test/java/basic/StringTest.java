package basic;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

  @Test
  void 항목이_여러개일_경우_Split_테스() {
    String data = "1,2";
    String[] result = data.split(",");
    assertThat(result).contains("1");
  }

  @Test
  void 항목이트_하나일_경우_Split_테스트() {
    String data = "1";
    String[] result = data.split(",");
    assertThat(result).containsExactly("1");
  }

  @Test
  void 문자열_괄호제거_테스트() {
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
