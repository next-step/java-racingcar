package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

  @Test
  void createCars() {
    Cars cars = Cars.createCars(List.of("yeny", "yeeun", "pobi", "jason", "ydh"), 0);
    Cars expectedCars = new Cars(
        List.of(
            new Car("yeny", 0),
            new Car("yeeun", 0),
            new Car("pobi", 0),
            new Car("jason", 0),
            new Car("ydh", 0)
        )
    );
    assertThat(cars).isEqualTo(expectedCars);
  }

  @DisplayName("중복된 이름이 있으면 예외를 던진다.")
  @Test
  void createCarsWithSameName() {
    assertThatThrownBy(() -> Cars.createCars(List.of("yeeun", "yeeun", "yeny"), 0))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void move() {
    Cars cars = Cars.createCars(List.of("yeny", "yeeun", "pobi", "jason", "ydh"), 0);
    cars.move(() -> true);

    Cars movedCars = Cars.createCars(List.of("yeny", "yeeun", "pobi", "jason", "ydh"), 1);
    assertThat(cars).isEqualTo(movedCars);
  }
}
