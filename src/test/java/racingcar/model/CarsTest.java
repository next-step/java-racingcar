package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CarsTest {

  private Cars cars;

  @BeforeEach
  void setup() {
    cars = Cars.createCars(List.of("yeny", "yeeun", "pobi", "jason", "ydh"), 0);
  }

  @Test
  void createCars() {
    Cars expectedCars = new Cars(
        List.of(
            new Car("yeny", 0),
            new Car("yeeun", 0),
            new Car("pobi", 0),
            new Car("jason", 0),
            new Car("ydh", 0)
        )
    );

    assertThat(cars.size()).isEqualTo(5);
    assertThat(cars).isEqualTo(expectedCars);
  }

  @Test
  void move() {
    cars.move(() -> true);

    Cars movedCars = Cars.createCars(List.of("yeny", "yeeun", "pobi", "jason", "ydh"), 1);
    assertThat(cars).isEqualTo(movedCars);
  }
}
