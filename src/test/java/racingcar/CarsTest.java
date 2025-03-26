package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

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
  void findWinners() {
    Names names = new Names(new String[]{"car1", "car2"});
    Cars cars = new Cars(names);
    cars.at(0).addScore(3);
    cars.at(1).addScore(3);

    assertThat(cars.findWinners()).hasSize(2);
  }

  @Test
  void findWinner() {
    Names names = new Names(new String[]{"car1", "car2"});
    Cars cars = new Cars(names);
    cars.at(0).addScore(2);
    cars.at(1).addScore(3);

    assertThat(cars.findWinners()).hasSize(1);
  }
}
