package racing.types;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RacingCarNameTest {

  @DisplayName("자동차 이름을 할당하지 않으면 default 값으로 생성한다.")
  @Test
  void constructor_givenNotCarName_assignDefaultCarName() {
    assertThat(new RacingCar().getName()).isEqualTo(RacingCarName.DEFAULT_NAME);
  }

  @DisplayName("자동차 이름의 길이는 5 이하이다.")
  @ParameterizedTest
  @ValueSource(strings = {"a", "aa", "aaa", "aaaa", "aaaaa"})
  void constructor_givenCarNameLengthIsFiveOrLess_doesNotThrowException(String carName) {
    assertDoesNotThrow(() -> new RacingCarName(carName));
  }

  @DisplayName("자동차 이름의 길이가 6 이상이면 RuntimeException을 던진다.")
  @ParameterizedTest
  @ValueSource(strings = { "abcdef", "longname", "123456", "longerName" })
  void constructor_givenCarNameLengthIsSixOrMore_throwsException(String carName) {
    assertThrows(RuntimeException.class, () -> new RacingCarName(carName));
  }

  @DisplayName("자동차 이름이 빈 문자열이면 RuntimeException을 던진다.")
  @Test
  void constructor_givenEmptyStringName_throwsException() {
    assertThrows(RuntimeException.class, () -> new RacingCarName(""));
  }

  @DisplayName("자동차 이름이 null이면 RuntimeException을 던진다.")
  @Test
  void constructor_givenNull_throwsException() {
    assertThrows(RuntimeException.class, () -> new RacingCarName(null));
  }
}
