package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

  @DisplayName("요구사항 1: 문자열 분리와 AssertJ를 이용한 배열 요소 검증 방법 학습")
  @Test
  void split() throws Exception {
    String[] result = "1,2".split(",");
    assertThat(result).contains("1", "2");
    assertThat(result).containsExactly("1", "2");
  }

  @DisplayName("요구사항 2: substring() 메소드를 활용한 문자열 자르기")
  @Test
  void substring() throws Exception {
    String result = "(1,2)".substring(1, 4);
    assertThat(result).isEqualTo("1,2");
  }

  @DisplayName("요구사항 3: charAt() 메소드를 활용한 특정 위치 문자 추출")
  @Test
  void charAt() {
    String data = "abc";
    assertThat(data.charAt(0)).isEqualTo('a');

    assertThatThrownBy(() -> {
      data.charAt(4);
    }).isInstanceOf(IndexOutOfBoundsException.class);

    assertThatThrownBy(() -> {
      data.charAt(3);
    }).isInstanceOf(StringIndexOutOfBoundsException.class)
        .hasMessageContaining("String index out of range: 3");
  }


}
