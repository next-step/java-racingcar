package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
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

    assertThat(cars.size()).isEqualTo(5);
    assertThat(cars).isEqualTo(expectedCars);
  }

  @Test
  void move() {
    Cars cars = Cars.createCars(List.of("yeny", "yeeun", "pobi", "jason", "ydh"), 0);
    cars.move(() -> true);

    Cars movedCars = Cars.createCars(List.of("yeny", "yeeun", "pobi", "jason", "ydh"), 1);
    assertThat(cars).isEqualTo(movedCars);
  }

  @Test
  void findWinners() {
    Cars cars = new Cars(
        List.of(
            new Car("yeny", 3),
            new Car("yeeun", 3),
            new Car("pobi", 2),
            new Car("jason", 1),
            new Car("ydh", 0)
        )
    );

    List<String> winnerNames = cars.findWinners().stream()
        .map(Car::getName)
        .collect(Collectors.toList());
    assertThat(winnerNames).containsExactly("yeny", "yeeun");
  }
}
