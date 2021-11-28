package racingCar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarsTest {

  @Test
  @DisplayName("Test find winner.")
  public void findWinner() {
    RacingCar car = new RacingCar(1, "car1");
    RacingCar winner1 = new RacingCar(2, "car2");
    RacingCar winner2 = new RacingCar(2, "car3");

    RacingCars racingCars = new RacingCars(Arrays.asList(car, winner1, winner2));

    Winners winners = racingCars.findWinners();
    Winners expected = new Winners(new RacingCars(Arrays.asList(winner1, winner2)));

    assertEquals(winners.findWinnersName().size(), expected.findWinnersName().size());
    assertThat(winners).isEqualTo(expected);
  }
}
