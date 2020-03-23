package carracing;

import carracing.model.CarRacing;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingTest {
  private static final int PERIOD = 9;
  private static final int CAR_COUNT = 5;
  private static final int INITIAL_POSITION = 0;
  private static final int MOVED_ONCE = 1;

  @Test
  public void proceedOnePeriodTest() {
    CarRacing carRacing = new CarRacing(PERIOD, CAR_COUNT);
    carRacing.proceedOnePeriod();

    assertThat(carRacing.getCarPositions()).hasSize(CAR_COUNT);
    carRacing.getCarPositions()
        .forEach(position -> assertThat(position).isBetween(INITIAL_POSITION, MOVED_ONCE));
  }

  @Test
  public void raceTest() {
    CarRacing carRacing = new CarRacing(PERIOD, CAR_COUNT);
    carRacing.race();

    assertThat(carRacing.getCarPositions()).hasSize(CAR_COUNT);
    carRacing.getCarPositions()
        .forEach(position -> assertThat(position).isBetween(INITIAL_POSITION, PERIOD));
  }
}
