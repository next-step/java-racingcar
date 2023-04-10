package study.racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class CarsTest {

  private List<Car> cars;


  @BeforeEach
  public void setUp() {
    cars = new ArrayList<>();
  }

  @Test
  @DisplayName("Cars 객체 크기 확인 테스트")
  public void cars() {
    cars.add(new Car());
    cars.add(new Car());
    cars.add(new Car());

    assertThat(cars).hasSize(3);
  }

  @Test
  @DisplayName("Cars 전진 테스트")
  public void forwardCars() {
    for (Car car : cars) {
      car.forward(new RacingGameStrategy());
      car.forward(new RacingGameStrategy());
      car.forward(new RacingGameStrategy());

      assertThat(car.distance()).isBetween(0, 3);
    }
  }
}
