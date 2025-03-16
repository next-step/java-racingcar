package racing.simulator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class CarTest {

  @DisplayName("전략에 따라 차를 이동한다.")
  @ParameterizedTest
  @ValueSource(booleans = {true, false})
  void go_carMovedByStrategy(boolean strategyResult) {
    int simulateCount = 4;
    Car car = new Car(() -> strategyResult);

    for (int i = 0; i < simulateCount; i++) {
      car.go();
    }

    assertThat(car.getLocation()).isEqualTo(strategyResult ? simulateCount : 0);
  }
}
