package racing.simulator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RacingCarTest {

  @DisplayName("전략에 따라 차를 이동한다.")
  @ParameterizedTest
  @ValueSource(booleans = {true, false})
  void go_carMovedByStrategy(boolean strategyResult) {
    int simulateCount = 4;
    RacingCar racingCar = new RacingCar();

    for (int i = 0; i < simulateCount; i++) {
      racingCar.go(()-> strategyResult);
    }

    assertThat(racingCar.getLocation()).isEqualTo(strategyResult ? simulateCount : 0);
  }

  @DisplayName("reset하면 차의 위치를 0으로 만든다.")
  @Test
  void reset_setLocationZero() {
    int simulateCount = 4;
    RacingCar racingCar = new RacingCar();

    for (int i = 0; i < simulateCount; i++) {
      racingCar.go(() -> true);
    }

    racingCar.reset();

    assertThat(racingCar.getLocation()).isEqualTo(0);
  }
}
