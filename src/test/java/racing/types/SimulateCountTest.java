package racing.types;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class SimulateCountTest {

  @DisplayName("시뮬레이션 수 값이 0 또는 음수일 때 생성자를 호출하면 RuntimeException을 던진다.")
  @ParameterizedTest
  @ValueSource(ints = {0, -1})
  void constructor_notPositiveNumberSimulationCount_throwRuntimeException(int simulateCount) {
    assertThrows(RuntimeException.class, () -> new SimulateCount(simulateCount));
  }
}
