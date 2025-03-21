package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {
  @Test
  @DisplayName("우승자가 한 명이면 한 명의 이름을 반환한다.")
  void getWinnerOne() {
    Cars cars = new Cars(new ArrayList<>());
    cars = cars.withAddedCar(new Car("pobi", 2));
    cars = cars.withAddedCar(new Car("crong", 1));
    cars = cars.withAddedCar(new Car("honux", 1));

    assertThat(cars.getWinners(cars)).containsExactly("pobi");
  }

  @Test
  @DisplayName("우승자가 여러 명이면 여러 명의 이름을 반환한다.")
  void getWinnerMultiple() {
    Cars cars = new Cars(new ArrayList<>());
    cars = cars.withAddedCar(new Car("pobi", 1));
    cars = cars.withAddedCar(new Car("crong", 1));
    cars = cars.withAddedCar(new Car("honux", 1));

    assertThat(cars.getWinners(cars)).containsExactlyInAnyOrder("pobi", "crong", "honux");
  }

}
