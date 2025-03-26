package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class CarsTest {

  @Test
  void size() {
    Names names = new Names(new String[]{"car1", "car2", "car3"});
    Cars cars = new Cars(names);
    assertThat(cars.size()).isEqualTo(3);
  }

  @Test
  void at() {
    Names names = new Names(new String[]{"car1", "car2", "car3"});
    Cars cars = new Cars(names);
    assertThat(cars.at(1).getName()).isEqualTo("car2");
  }

  @Test
  void findWinners_공동_우승() {
    Names names = new Names(new String[]{"car1", "car2"});
    Cars cars = new Cars(names);
    cars.at(0).addScore(3);
    cars.at(1).addScore(3);

    List<Car> expected = List.of(
        new Car("car1", 3),
        new Car("car2", 3)
    );
    assertThat(cars.findWinners())
        .usingRecursiveComparison()
        .isEqualTo(expected);
  }

  @Test
  void findWinners_단독_우승() {
    Names names = new Names(new String[]{"car1", "car2"});
    Cars cars = new Cars(names);
    cars.at(0).addScore(2);
    cars.at(1).addScore(3);

    List<Car> expected = List.of(
        new Car("car2", 3)
    );
    assertThat(cars.findWinners())
        .usingRecursiveComparison()
        .isEqualTo(expected);
  }
}
