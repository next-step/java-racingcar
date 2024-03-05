package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {

  @Test
  @DisplayName("[요구사항1] ,를 기준으로 잘 분리되는지 테스트")
  void splitTest() {
    String given = "1,2";
    String[] result = given.split(",");
    assertThat(result).containsExactly("1", "2");
  }

  @Test
  @DisplayName("[요구사항1] ,를 기준으로 잘 분리되는지 테스트")
  void splitTest2() {
    String given = "1";
    String[] result = given.split(",");
    assertThat(result).containsExactly("1");
  }

  @Test
  @DisplayName("[요구사항2] substring 테스트")
  void subStringTest() {
    String given = "(1,2)";
    String result = given.substring(1, given.length() - 1);
    assertThat(result).isEqualTo("1,2");
  }

  @Test
  @DisplayName("[요구사항3] charAt() 메소드를 활용해 특정 위치의 문자를 가져오는지 테스트")
  void charAtTest() {
    String given = "abc";
    char result = given.charAt(1);
    assertThat(result).isEqualTo('b');
  }

  @Test
  @DisplayName("[요구사항3] 문자열 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 테스트")
  void stringIndexOutOfBoundsExceptionTest() {
    String given = "abc";
    assertThatThrownBy(() -> given.charAt(-1)).isInstanceOfAny(IndexOutOfBoundsException.class);
  }
}
