package carracing;

import carracing.model.CarRacing;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import static carracing.model.Car.INITIAL_POSITION;
import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingTest {
  private static final int ROUND = 9;
  private static final int MOVED_ONCE = 1;
  private static final List<String> CAR_NAMES = new ArrayList<>(Arrays.asList("Audi", "Benz", "BMW"));

  @Test
  public void proceedOneRoundTest() {
    CarRacing carRacing = new CarRacing(CAR_NAMES, ROUND);
    carRacing.proceedOneRound();

    assertThat(carRacing.getCars()).hasSize(CAR_NAMES.size());
    carRacing.getCars()
        .forEach(car -> car.getPositions()
            .forEach(position -> assertThat(position)
                .isBetween(INITIAL_POSITION, INITIAL_POSITION + MOVED_ONCE))
        );
  }

  @Test
  public void raceTest() {
    CarRacing carRacing = new CarRacing(CAR_NAMES, ROUND);
    carRacing.race();

    assertThat(carRacing.getCars()).hasSize(CAR_NAMES.size());
    carRacing.getCars()
        .forEach(car -> car.getPositions()
            .forEach(position -> assertThat(position).isBetween(INITIAL_POSITION, INITIAL_POSITION + ROUND))
        );
  }
}
