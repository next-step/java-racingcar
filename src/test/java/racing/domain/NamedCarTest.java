package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.domain.strategy.MustMoveStrategy;

class NamedCarTest {

  @Test
  @DisplayName("앞으로 1회 이동했을 때 이동 거리와 자동차 이름 확인")
  void oneMoveTest() {
    String carName = "car";
    NamedCar namedCar = NamedCar.newInstance(carName, new MustMoveStrategy());

    namedCar.attempt();

    assertThat(namedCar.getDistance()).isEqualTo(1);
    assertThat(namedCar.getCarName()).isEqualTo(carName);
  }

  @ParameterizedTest
  @DisplayName("앞으로 n회 이동했을 때 이동 거리와 자동차 이름 확인")
  @CsvSource(value = {"A|1|1", "B|2|2", "C|0|0", "D|10|10", "E|100|100"}, delimiter = '|')
  void nMoveTest(String carName, int n, int expected) {
    NamedCar namedCar = NamedCar.newInstance(carName, new MustMoveStrategy());
    for (int i = 0; i < n; i++) {
      namedCar.attempt();
    }

    assertThat(namedCar.getDistance()).isEqualTo(expected);
    assertThat(namedCar.getCarName()).isEqualTo(carName);
  }

  @ParameterizedTest
  @DisplayName("시도 갯수를 받아 n회 시도했을 때 이동 거리와 자동차 이름 확인")
  @CsvSource(value = {"test|1", "test2|2", "test3|0", "test4|10", "test5|100"}, delimiter = '|')
  void randomMoveTest(String carName, int attempt) {
    //given
    NamedCar namedCar = NamedCar.newInstance(carName, new MustMoveStrategy());

    //when
    for (int i = 0; i < attempt; i++) {
      namedCar.attempt();
    }

    //then
    assertThat(namedCar.getDistance()).isEqualTo(attempt);
  }

  @ParameterizedTest
  @DisplayName("자동차 이름들과 시도 갯수를 받아 따라 n회 시도했을 때 이동 거리와 자동차 이름 확인")
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