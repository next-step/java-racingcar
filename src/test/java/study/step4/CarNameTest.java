package study.step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.step4.domain.CarName;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.step4.domain.CarName.*;

public class CarNameTest {

  @ParameterizedTest
  @NullAndEmptySource
  @DisplayName("자동차 이름이 null 또는 빈 값일 경우 에러 발생")
  void carNameTest(String given) {
    assertThatThrownBy(() -> CarName.naming(given))
        .isInstanceOfAny(IllegalArgumentException.class)
        .hasMessageContaining(String.format(MUST_EXCEED_CERTAIN_LENGTH, NAME_MINIMUM_LENGTH, given));
  }

  @ParameterizedTest
  @ValueSource(strings = {"123456", "123456789"})
  @DisplayName("자동차 이름이 5자 초과일 경우 에러 발생")
  void carNameTest2(String given) {
    assertThatThrownBy(() -> CarName.naming(given))
        .isInstanceOfAny(IllegalArgumentException.class)
        .hasMessageContaining(String.format(EXCEEDED_MAXIMUM_LENGTH, NAME_MAXIMUM_LENGTH, given, given.length()));
  }

  @ParameterizedTest
  @ValueSource(strings = {"pobi", "crong", "honux"})
  @DisplayName("자동차 이름이 5자 이하일 경우 정상 생성")
  void carNameTest3(String given) {
    assertThat(CarName.naming(given).get()).isEqualTo(given);
  }
}
