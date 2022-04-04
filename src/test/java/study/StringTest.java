package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

  @Test
  @DisplayName("integer 배열를 split 했을때 특정 문자가 포함되는지 테스트-1")
  void split_containsTest() {
    String[] result = "1,2".split(",");
    assertThat(result).contains("1");
  }

  @Test
  @DisplayName("integer 배열를 split 했을때 특정 문자가 포함되는지 테스트-2")
  void split_containsTest_2() {
    String[] result = "1".split(",");
    assertThat(result).contains("1");
  }

  @Test
  @DisplayName("integer 배열를 split 했을때 순서에 맞는지 테스트")
  void split_containsExactlyTest() {
    String[] result = "1,2".split(",");
    assertThat(result).containsExactly("1", "2");

  }

  @Test
  @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 테스트")
  void string_charAt_Test() {
    String answer = "abc";
    char result = answer.charAt(1);
    assertThat('b').isEqualTo(result);
  }

  @Test
  @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올때 범위를 벗어나는 경우 테스트")
  void string_charAt_exception_Test() {
    assertThatThrownBy(() -> {
      String answer = "abc";
      char result = answer.charAt(5);
    }).isInstanceOf(IndexOutOfBoundsException.class);
  }


}
