package racinggame.model;

import static org.assertj.core.api.Assertions.assertThat;

import com.sun.tools.javac.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarsTest {

  private static int RACING_CAR_COUNT = 4;
  private static RacingCars racingCars = new RacingCars(RACING_CAR_COUNT);

  @Test
  @DisplayName("참가한 CAR수가 객체안의 CAR수와 동일한가?")
  void getCarCount() {
    RacingCars assertRacingCars = new RacingCars(List.of(new Car(0), new Car(1), new Car(2), new Car(3)));
    assertThat(RacingCarsTest.racingCars).isEqualTo(assertRacingCars);
  }

}