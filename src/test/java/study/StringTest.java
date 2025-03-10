package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {
  @Test
  @DisplayName("요구사항 1: \"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인")
  void testSplitCase1() {
    String input = "1,2";
    String[] result = input.split(",");
    assertThat(result).containsExactly("1", "2");
  }

  @Test
  @DisplayName("요구사항 1: \"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인")
  void testSplitCase2() {
    String input = "1";
    String[] result = input.split(",");
    assertThat(result).containsExactly("1");
  }

  @Test
  @DisplayName("요구사항 2: \"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환")
  void testSubstringCase1() {
    String input = "(1,2)";
    String result = input.substring(1, 4);
    assertThat(result).isEqualTo("1,2");
  }

  @Test
  @DisplayName("요구사항 3: \"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져온다")
  void testCharAtCase1(){
    String input = "abc";
    int idx = 0;
    char result = input.charAt(idx);
    assertThat(result).isEqualTo('a');
  }

  @Test
  @DisplayName("요구사항 3: StringIndexOutOfBoundsException이 발생하는지 확인")
  void testCharAtCase2(){
    String input = "abc";
    int idx = 100;
    assertThatThrownBy(() -> {
      input.charAt(idx);
    }).isInstanceOf(IndexOutOfBoundsException.class)
      .hasMessageContaining("String index out of range: " + idx);
  }
}
