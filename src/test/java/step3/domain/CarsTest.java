package step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.service.RacingRule;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

  private Cars cars;

  private RacingRule createRandomRacingRule(int number) {
    return () -> number;
  }

  @BeforeEach
  void before() {
    cars = new Cars(Arrays.asList(
        new Car("pobi"),
        new Car("crong"),
        new Car("honux")
    ));
  }

  @DisplayName("모두 이동 가능한 조건이라, 이동한 경우")
  @Test
  public void canMove() {
    cars.race(createRandomRacingRule(5));
    assertThat(cars.getCars().size()).isEqualTo(3);
    for (Car car : cars.getCars()) {
      assertThat(car.getDistance()).isEqualTo(2);
    }
  }

  @DisplayName("모두 이동 가능하지 못한 조건이라, 이동 못한 경우")
  @Test
  public void cannotMove() {
    cars.race(createRandomRacingRule(1));
    assertThat(cars.getCars().size()).isEqualTo(3);
    for (Car car : cars.getCars()) {
      assertThat(car.getDistance()).isEqualTo(1);
    }
  }

  @DisplayName("게임의 단독승자를 확인")
  @Test
  void getWinnerCarTest() {
    Cars cars = new Cars(Arrays.asList(
        new Car("A", 1),
        new Car("B", 2),
        new Car("C", 3)
    ));
    assertThat(cars.getWinnerCarNames().size()).isEqualTo(1);
    assertThat(cars.getWinnerCarNames().get(0)).isEqualTo("C");
  }

  @DisplayName("게임의 여러 승자를 확인")
  @Test
  void getWinnerCarMultiTest() {
    Cars cars = new Cars(Arrays.asList(
        new Car("A", 1),
        new Car("B", 3),
        new Car("C", 3)
    ));
    assertThat(cars.getWinnerCarNames().size()).isEqualTo(2);
    assertThat(cars.getWinnerCarNames().get(0)).isEqualTo("B");
    assertThat(cars.getWinnerCarNames().get(1)).isEqualTo("C");
  }
}
