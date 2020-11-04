package racinggame.domain.model;

import static org.assertj.core.api.Assertions.assertThat;

import com.sun.tools.javac.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.domain.Car;
import racinggame.domain.rule.RandomMoveRule;

class RacingCarsTest {

  private static String[] RACING_CAR_NAMES = {"a", "b", "c"};
  private static RacingCars racingCars = new RacingCars(RACING_CAR_NAMES, new RandomMoveRule());

  @Test
  @DisplayName("참가한 CAR수가 객체안의 CAR수와 동일한가?")
  void getCarCount() {
    RacingCars assertRacingCars = new RacingCars(List.of(Car.newInstanceByCarName("a"),Car.newInstanceByCarName("b"), Car.newInstanceByCarName("c")));
    assertThat(RacingCarsTest.racingCars).isEqualTo(assertRacingCars);
  }
}