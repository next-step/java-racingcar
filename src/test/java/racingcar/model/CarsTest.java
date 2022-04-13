package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class CarsTest {

  @Test
  void getPositions_all_move() {
    List<Car> carList = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      Car car = new Car();
      car.moveOrStop(5);
      carList.add(car);
    }
    Cars cars = new Cars(carList);

    assertThat(cars.getPositions()).hasSize(carList.size());
    assertThat(cars.getPositions()).containsExactly(1, 1, 1, 1, 1);
  }

  @Test
  void getPositions_all_stop() {
    List<Car> carList = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      Car car = new Car();
      car.moveOrStop(1);
      carList.add(car);
    }
    Cars cars = new Cars(carList);

    assertThat(cars.getPositions()).hasSize(carList.size());
    assertThat(cars.getPositions()).containsExactly(0, 0, 0, 0, 0);
  }
}
