package learningTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.in;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

  @Test
  @DisplayName("문자열 `1,2`를 `,`로 split하면 `1`과 `2`를 포함하는 배열을 반환한다")
  void splitTest() {
    // given
    String input = "1,2";

    // when
    String[] splitInput = input.split(",");

    // then
    assertThat(splitInput).containsExactlyInAnyOrder("1", "2");
  }
  
  @Test
  @DisplayName("문자열 `1`을 `,`로 split했을 때 `1`만을 가지는 배열을 반환한다")
  void splitNotContainsSeparatorFromOriginTest() {
    // given
    String input = "1";
    
    // when
    String[] splitInput = input.split(",");
    
    // then
    assertThat(splitInput).containsExactlyInAnyOrder("1");
  }

  @Test
  @DisplayName("문자열 `(1,2)`에 대해 substring 메서드로 괄호를 제거할 수 있다")
  void substringTest() {
    // given
    String input = "(1,2)";

    // when
    String substringInput = input.substring(1, 4);

    // then
    assertThat(substringInput).isEqualTo("1,2");
  }

  @Test
  @DisplayName("charAt 메서드로 특정 위치의 문자를 가져올 수 있다")
  void charAtTest() {
    // given
    String input = "abc";

    // when
    char extractedInput = input.charAt(0);

    // then
    assertThat(extractedInput).isEqualTo('a');
  }

  @Test
  @DisplayName("charAt 메서드는 위치 값을 벗어난 위치를 요청하면 StringIndexOutOfBoundsException 예외를 발생시킨다")
  void charAtStringIndexOutOfBoundsExceptionTest() {
    // given
    String input = "abc";
    int index = 5;

    // when & then
    assertThatThrownBy(() -> input.charAt(index))
        .isInstanceOf(StringIndexOutOfBoundsException.class)
        .hasMessage(String.format("String index out of range: %d", index));
  }
}
