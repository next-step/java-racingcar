package racing.types;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CarCountTest {

  @DisplayName("생성자 테스트1")
  @Test
  void constructorTest1() {
    assertDoesNotThrow(() -> CarCount.valueOf(3));
  }

  @DisplayName("자동차 수 값이 1, 0, 음수일 때 생성자를 호출하면 RuntimeException을 던진다.")
  @ParameterizedTest
  @ValueSource(ints = {0, 1, -1})
  void constructor_givenZeroOrOneOrNegativeCarCount_throwsRuntimeException(int carCount) {
    assertThrows(RuntimeException.class, () -> CarCount.valueOf(carCount));
  }
}
