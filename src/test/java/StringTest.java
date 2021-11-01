import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {

  private final String DELIMITER = ",";
  private final String ABC = "abc";

  @Test
  @DisplayName("문자열 \"1,2\"를 split했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트")
  void splitStringHasTwoNumbers() {
    // given
    String oneCommaTwo = "1,2";

    // when
    String[] splitResult = oneCommaTwo.split(DELIMITER);

    // then
    assertThat(splitResult)
      .containsExactly("1", "2");
  }

  @Test
  @DisplayName("문자열 \"1\"을 split했을 때 1만을 포함하는 배열이 반환되는지 확인하는 학습 테스트")
  void splitStringHasOneNumber() {
    // given
    String justOne = "1";

    // when
    String[] splitResult = justOne.split(DELIMITER);

    // then
    assertThat(splitResult)
            .containsExactly("1");
  }

  @Test
  @DisplayName("괄호를 포함한 문자열 \"(1,2)\"를 substring() 메소드를 활용해 ()을 제거한 이후 split했을 때 " +
          "1과 2로 잘 분리되는지 확인하는 학습 테스트")
  void splitStringHasTwoNumbersWithBrackets() {
    // given
    String oneCommaTwoWithBrackets = "(1,2)";
    String oneCommaTwo = oneCommaTwoWithBrackets.substring(1,4);

    // when
    String[] splitResult = oneCommaTwo.split(DELIMITER);

    // then
    assertThat(oneCommaTwo)
            .doesNotContain("(", ")");
    assertThat(splitResult)
            .containsExactly("1", "2");
  }

  @Test
  @DisplayName("charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 것을 확인하기 위한 학습 테스트")
  void charAt() {
    // when
    char firstChar = ABC.charAt(0);

    // then
    assertThat(firstChar)
            .isEqualTo('a');
  }

  @Test
  @DisplayName("charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치값을 벗어난 경우 " +
          "StringIndexOutOfBoundsException이 발생함을 확인하기 위한 학습 테스트")
  void charAtByOutOfBoundIndexCauseException() {
    // given
    int index = 3;

    // when
    assertThatThrownBy(() -> {
      ABC.charAt(index);
    })
            // then
            .isInstanceOf(StringIndexOutOfBoundsException.class)
            .hasMessageContaining(String.format("%d",index));
  }

}
