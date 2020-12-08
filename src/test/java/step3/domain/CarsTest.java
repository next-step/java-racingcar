package step3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.service.RacingRule;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {

  private Cars cars;

  private RacingRule createTestRacingRule(boolean canMove) {
    return new RacingRule() {
      @Override
      public boolean canMove(int targetNumber) {
        return canMove;
      }

      @Override
      public int getTargetNumber() {
        return 0;
      }
    };
  }

  @BeforeEach
  void before() {
    cars = new Cars("pobi,crong,honux");
  }

  @DisplayName("모두 이동 가능한 조건이라, 이동한 경우")
  @Test
  public void canMoveIsTrue() {
    cars.race(createTestRacingRule(true));
    assertThat(cars.getCars().size()).isEqualTo(3);
    for (Car car : cars.getCars()) {
      assertThat(car.getDistance()).isEqualTo(2);
    }
  }

  @DisplayName("모두 이동 가능하지 못한 조건이라, 이동 못한 경우")
  @Test
  public void canMoveIsFalse() {
    cars.race(createTestRacingRule(false));
    assertThat(cars.getCars().size()).isEqualTo(3);
    for (Car car : cars.getCars()) {
      assertThat(car.getDistance()).isEqualTo(1);
    }
  }


}
