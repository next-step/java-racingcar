package carracing.domain;

import carracing.domain.entity.Car;
import carracing.domain.entity.Winner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class WinnerTest {

  @ParameterizedTest
  @MethodSource("makeWinner")
  @DisplayName("차의 목록을 받아 그 중 가장 많이 전진한 차들을 반환한다.")
  void pickWinnerTest(List<Car> carList, String name) {
    Winner winnerList = Winner.pickWinner(carList);
    for (Car car : winnerList.getWinnerList()) {
      assertThat(car.getName()).isEqualTo(name);
    }
  }

  static Stream<Arguments> makeWinner() {
    List<Car> cars = Arrays.asList(new Car("kevin"), new Car("poo"), new Car("bar"));
    Car car = cars.get(0);
    car.move(() -> true);

    List<Car> carList = Arrays.asList(new Car("duke"), new Car("rabbit"), new Car("tune"));
    Car secondCar = carList.get(1);
    secondCar.move(() -> true);

    return Stream.of(
            Arguments.of(cars, car.getName()),
            Arguments.of(carList, secondCar.getName()));
  }

}