package racing.types;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CarCountTest {

  @DisplayName("자동차 수 값이 1, 0, 음수일 때 생성자를 호출하면 RuntimeException을 던진다.")
  @ParameterizedTest
  @ValueSource(ints = {0, 1, -1})
  void constructor_givenZeroOrOneOrNegativeCarCount_throwsRuntimeException(int carCount) {
    assertThrows(RuntimeException.class, () -> new CarCount(carCount));
  }
}
