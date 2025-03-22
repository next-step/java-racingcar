package racing.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.property.CarRacingGameProperty;
import racing.types.Car;
import racing.types.CarName;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


class CarNameInputSplitterTest {

  @DisplayName("차의 이름들을 받았을 때 모두 5자리 이하 2자리 이상의 이름이면 쉼표(,) 단위로 구분한다.")
  @Test
  void splitCarNames_givenCommaSeparatedString_returnsListOfCarNames() {
    List<CarName> result = CarNameInputSplitter.split("pobi,crong,honux");

    assertThat(result)
        .isNotNull()
        .hasSize(3)
        .containsExactly(CarName.valueOf("pobi"), CarName.valueOf("crong"), CarName.valueOf("honux"));
  }

  @DisplayName("차의 이름들을 받았을 때 2대 미만이면 RuntimeException을 던진다.")
  @Test
  void throwRuntimeException_whenLessThanTwoCarNamesProvided() {
    assertThrows(RuntimeException.class, () -> CarNameInputSplitter.split("pobi"));
  }

  @DisplayName("차의 이름들을 받았을 때 이름 중 하나라도 빈 문자열이면 RuntimeException을 던진다.")
  @Test
  void throwRuntimeException_whenAnyCarNameIsEmpty() {
    assertThrows(RuntimeException.class, () -> CarNameInputSplitter.split("pobi,,crong"));
  }

  @DisplayName("차의 이름들을 받았을 때 null이면 RuntimeException을 던진다.")
  @Test
  void throwRuntimeException_whenCarNamesNull() {
    assertThrows(RuntimeException.class, () -> CarNameInputSplitter.split(null));
  }

  @DisplayName("차의 이름들을 받았을 때 중복된 이름이 있으면 RuntimeException을 던진다.")
  @Test
  void throwRuntimeException_whenDuplicateCarNames() {
    assertThrows(RuntimeException.class, () -> CarNameInputSplitter.split("pobi,pobi"));
  }

  @DisplayName("차의 이름들을 받았을 CarName Default 이름이 있으면 RuntimeException을 던진다.")
  @Test
  void throwRuntimeException_whenDefaultCarNames() {
    assertThrows(RuntimeException.class, () -> CarNameInputSplitter.split(String.format("pobi,%s", CarRacingGameProperty.CAR_DEFAULT_NAME)));
  }
}
