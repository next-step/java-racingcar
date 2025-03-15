package racing.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class InputValidatorTest {

  @DisplayName("자동차 수 값이 1, 0, 음수일 때 검증 로직을 호출하면 RuntimeException을 던진다.")
  @ParameterizedTest
  @ValueSource(ints = {0, 1, -1})
  void isNotValidCarCount_notPositiveNumberCarCount_returnTrue(int carCount) {
    assertThrows(RuntimeException.class, () -> InputValidator.checkNotValidCarCount(carCount));
  }

  @DisplayName("시뮬레이션 수 값이 0 또는 음수일 때 검증 로직을 호출하면 RuntimeException을 던진다.")
  @ParameterizedTest
  @ValueSource(ints = {0, -1})
  void isNotSimulateCount_notPositiveNumberSimulationCount_returnTrue(int simulateCount) {
    assertThrows(RuntimeException.class, () -> InputValidator.checkNotValidSimulateCount(simulateCount));
  }
}
