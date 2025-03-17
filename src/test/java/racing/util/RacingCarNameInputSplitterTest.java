package racing.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.types.RacingCarName;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;


class RacingCarNameInputSplitterTest {

  @DisplayName("차의 이름들을 받았을 때 모두 5자리 이하 2자리 이상의 이름이면 쉼표(,) 단위로 구분한다.")
  @Test
  void splitCarNames_givenCommaSeparatedString_returnsListOfCarNames() {
    String input="pobi,crong,honux";

    List<RacingCarName> result = RacingCarNameInputSplitter.split(input);

    assertThat(result)
        .isNotNull()
        .hasSize(3)
        .extracting(RacingCarName::getName)
        .containsExactly("pobi", "crong", "honux");
  }

  @DisplayName("차의 이름들을 받았을 때 2대 미만이면 RuntimeException을 던진다.")
  @Test
  void throwRuntimeException_whenLessThanTwoCarNamesProvided() {
    String input="pobi";

    assertThrows(RuntimeException.class, () -> RacingCarNameInputSplitter.split(input));
  }

  @DisplayName("차의 이름들을 받았을 때 이름 중 하나라도 빈 문자열이면 RuntimeException을 던진다.")
  @Test
  void throwRuntimeException_whenAnyCarNameIsEmpty() {
    String input="pobi,,crong";

    assertThrows(RuntimeException.class, () -> RacingCarNameInputSplitter.split(input));
  }
}
