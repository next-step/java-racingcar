package carracing;

import carracing.model.CarRacing;
import org.junit.jupiter.api.Test;

import static carracing.model.Car.INITIAL_POSITION;
import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingTest {
  private static final int ROUND = 9;
  private static final int CAR_COUNT = 5;
  private static final int MOVED_ONCE = 1;

  @Test
  public void proceedOneRoundTest() {
    CarRacing carRacing = new CarRacing(ROUND, CAR_COUNT);
    carRacing.proceedOneRound();

    assertThat(carRacing.getCars()).hasSize(CAR_COUNT);
    carRacing.getCars()
        .forEach(car -> car.getPositions()
            .forEach(position -> assertThat(position)
                .isBetween(INITIAL_POSITION, INITIAL_POSITION + MOVED_ONCE))
        );
  }

  @Test
  public void raceTest() {
    CarRacing carRacing = new CarRacing(ROUND, CAR_COUNT);
    carRacing.race(false);

    assertThat(carRacing.getCars()).hasSize(CAR_COUNT);
    carRacing.getCars()
        .forEach(car -> car.getPositions()
            .forEach(position -> assertThat(position).isBetween(INITIAL_POSITION, INITIAL_POSITION + ROUND))
        );
  }
}
