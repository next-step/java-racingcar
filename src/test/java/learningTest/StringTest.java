package learningTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

  @Test
  @DisplayName("split 메서드는 구분자로 문자열을 분리할 수 있다")
  void splitTest() {
    // given
    String input = "1,2";

    // when
    String[] splitInput = input.split(",");

    // then
    assertThat(splitInput).containsExactlyInAnyOrder("1", "2");
  }
  
  @Test
  @DisplayName("대상 문자열에 구분자가 포함되지 않을 경우 split 메서드는 원문을 반환한다")
  void splitNotContainsSeparatorFromOriginTest() {
    // given
    String input = "1";
    
    // when
    String[] splitInput = input.split(",");
    
    // then
    assertThat(splitInput).containsExactlyInAnyOrder("1");
  }

  @Test
  @DisplayName("split 메서드에 구분자는 여러 개를 넣을 수 있다")
  void splitMultiDelimiterTest() {
    // given
    String input = "1:2,3_4";

    // when
    String[] splitInput = input.split(",|:|_");

    // then
    assertThat(splitInput).containsExactlyInAnyOrder("1", "2", "3", "4");
  }

  @Test
  @DisplayName("substring 메서드로 문자열을 일부만 추출할 수 있다")
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
