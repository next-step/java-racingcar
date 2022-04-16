package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.domain.strategy.MustMoveStrategy;

class CarTest {

  @Test
  @DisplayName("앞으로 1회 이동했을 때 이동 거리와 자동차 이름 확인")
  void oneMoveTest() {
    String carName = "car";
    Car car = Car.newInstance(carName, new MustMoveStrategy());

    car.attempt();
    assertAll(
        () -> assertThat(car.getDistance()).isEqualTo(1),
        () -> assertThat(car.getCarName()).isEqualTo(carName)
    );
  }

  @ParameterizedTest
  @DisplayName("앞으로 n회 이동했을 때 이동 거리와 자동차 이름 확인")
  @CsvSource(value = {"A|1|1", "B|2|2", "C|0|0", "D|10|10", "E|100|100"}, delimiter = '|')
  void nMoveTest(String carName, int attempt, int expected) {
    Car car = Car.newInstance(carName, new MustMoveStrategy());
    for (int i = 0; i < attempt; i++) {
      car.attempt();
    }
    assertAll(
        () -> assertThat(car.getDistance()).isEqualTo(expected),
        () -> assertThat(car.getCarName()).isEqualTo(carName)
    );
  }

}