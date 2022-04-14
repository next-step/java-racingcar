package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarsTest {

  private Cars cars;

  @BeforeEach
  void setup() {
    List<Car> carList = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      Car car = new Car();
      carList.add(car);
    }
    cars = new Cars(carList);
  }

  @Test
  void move() {
    List<Integer> numbers = List.of(1, 2, 3, 4, 5);
    cars.move(numbers);

    assertThat(cars.getPositions()).containsExactly(0, 0, 0, 1, 1);
  }

  @Test
  void getPositions_all_move() {
    for (int i = 0; i < 5; i++) {
      cars.getValues().get(i).moveOrStop(5);
    }

    assertThat(cars.getPositions()).hasSize(cars.getValues().size());
    assertThat(cars.getPositions()).containsExactly(1, 1, 1, 1, 1);
  }

  @Test
  void getPositions_all_stop() {
    for (int i = 0; i < 5; i++) {
      cars.getValues().get(i).moveOrStop(1);
    }

    assertThat(cars.getPositions()).hasSize(cars.getValues().size());
    assertThat(cars.getPositions()).containsExactly(0, 0, 0, 0, 0);
  }
}
