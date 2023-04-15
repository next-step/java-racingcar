package study.racinggame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class CarsTest {
  private Cars cars;


  @BeforeEach
  public void setUp() {
    cars = new Cars(new ArrayList<>(Arrays.asList(
            new Car("tobi", 3),
            new Car("oneny", 2),
            new Car("twony", 1))));
  }

  @Test
  @DisplayName("Cars 객체 크기 확인 테스트")
  public void cars() {
    assertThat(cars.cars()).hasSize(3);
  }

  @Test
  @DisplayName("Cars 전진 테스트")
  public void forwardCars() {
    for (Car car : cars.cars()) {
      assertThat(car.distance()).isBetween(0, 3);
    }
  }

  @Test
  @DisplayName("가장 멀리간 자동차 테스트")
  public void carNamesAtLongestDistance() {
    assertThat(cars.carNamesAtLongestDistance()).contains("tobi");
  }
}
