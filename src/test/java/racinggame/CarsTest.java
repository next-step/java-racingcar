package racinggame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domain.Car;
import racinggame.domain.Cars;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

  private Cars cars;

  @DisplayName("우승자 테스트 - 우승자가 1명")
  @Test
  void getWinner() {
    List<Car> carList  = Arrays.asList(
        new Car("test1", 5),
        new Car("test2", 4),
        new Car("test3", 4));

    cars = new Cars(carList);

    assertThat(this.cars.getWinner(cars.getMax()))
        .containsExactly("test1");
  }

  @DisplayName("우승자 테스트 - 우승자가 2명")
  @Test
  void getWinners() {
    List<Car> carList = Arrays.asList(
        new Car("test1", 5),
        new Car("test2", 5),
        new Car("test3", 3));

    cars = new Cars(carList);

    assertThat(this.cars.getWinner(cars.getMax()))
        .containsExactly("test1", "test2");
  }
}
