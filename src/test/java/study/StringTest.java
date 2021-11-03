package study;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.in;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

  @Test
  @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트")
  void testSplit() {
    // given
    String input = "1,2";

    // when
    String[] result = input.split(",");

    // then
    assertThat(result).contains("1","2");
    assertThat(result).containsExactly("1", "2");
  }

  @Test
  @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트")
  void testSplitOneCharacter() {
    // given
    String input = "1";

    // when
    String[] result = input.split(",");

    // then
    assertThat(result).contains("1");
    assertThat(result).containsExactly("1");
  }

  @Test
  @DisplayName("(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환")
  void testSubString(){
    // given
    String input = "(1,2)";

    // when
    String result = input.substring(1,4);

    // then
    assertThat(result).isEqualTo("1,2");
  }

  @Test
  @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트")
  void testCharAt(){
    // given
    String input = "abc";

    // when
    char result = input.charAt(1);

    // then
    assertThat(result).isEqualTo('b');
  }

  @Test
  @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트")
  void testCharAtError(){
    // given
    String input = "abc";


    // when
    assertThatThrownBy(()-> input.charAt(4))
        .isInstanceOf(StringIndexOutOfBoundsException.class);
  }
}
