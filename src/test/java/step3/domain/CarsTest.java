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
    return new RacingRule() {
      @Override
      public int getTargetNumber() {
        return number;
      }
    };
  }

  @BeforeEach
  void before() {
    cars = new Cars(Arrays.asList("pobi", "crong", "honux"));
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

  @Test
  void getWinnerCarTest() {
    cars.race(createRandomRacingRule(5));
    assertThat(cars.getWinnerCarNames().size()).isEqualTo(3);
  }
}
