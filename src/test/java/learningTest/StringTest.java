package learningTest;

import static org.assertj.core.api.Assertions.assertThat;

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


}
