package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.strategy.MustMoveStrategy;

class CarTest {

  @Test
  @DisplayName("앞으로 1회 이동했을 때 이동 거리 확인")
  void oneMoveTest() {
    Car car = new Car(new MustMoveStrategy());
    car.attempt();

    assertThat(car.getDistance()).isEqualTo(1);
  }

  @ParameterizedTest
  @DisplayName("앞으로 n회 이동했을 때 이동 거리 확인")
  @CsvSource(value = {"1|1", "2|2", "0|0", "10|10", "100|100"}, delimiter = '|')
  void nMoveTest(int n, int expected) {
    Car car = new Car(new MustMoveStrategy());
    for (int i = 0; i < n; i++) {
      car.attempt();
    }

    assertThat(car.getDistance()).isEqualTo(expected);
  }

  @ParameterizedTest
  @DisplayName("시도 갯수를 받아 n회 시도했을 때 이동 거리 확인")
  @ValueSource(ints = {1, 10, 50, 10000})
  void randomMoveTest(int attempt) {
    //given
    Car car = new Car(new MustMoveStrategy());

    //when
    for (int i = 0; i < attempt; i++) {
      car.attempt();
    }

    //then
    assertThat(car.getDistance()).isEqualTo(attempt);
  }

  @ParameterizedTest
  @DisplayName("차량 갯수와 시도 갯수를 받아 따라 n회 시도했을 때 이동 거리 확인")
  @CsvSource(value = {"1|1", "100|100", "52|52", "0|0"}, delimiter = '|')
  void randomCarMoveTest(int carCount, int attempt) {
    //given
    List<Car> cars = new ArrayList<>();
    for (int i = 0; i < carCount; i++) {
      cars.add(new Car(new MustMoveStrategy()));
    }

    //when
    for (Car car : cars) {
      for (int j = 0; j < attempt; j++) {
        car.attempt();
      }
    }

    //then
    for (Car car : cars) {
      assertThat(car.getDistance()).isEqualTo(attempt);
    }
  }

}