package carracing;

import carracing.model.Car;
import carracing.util.ProbabilityUtil;
import org.junit.jupiter.api.Test;

import static carracing.model.Positions.INITIAL_POSITION;
import static carracing.model.Positions.MOVED_ONCE;
import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
  private static final int INITIAL_ROUND = 0;
  private static final int TOTAL_ROUND = 10;
  private static final String CAR_NAME = "Audi";

  @Test
  public void moveTest() {
    Car car = new Car(CAR_NAME);

    for (int currentRound = INITIAL_ROUND; currentRound < TOTAL_ROUND; currentRound++) {
      Integer beforePosition = car.getFinalPosition();
      car.move(ProbabilityUtil.FOURTY_PERCENT);
      Integer afterPosition = car.getFinalPosition();
      assertThat(afterPosition).isBetween(beforePosition, beforePosition + MOVED_ONCE);
    }
  }

  @Test
  public void moveCertainlyTest() {
    Car car = new Car(CAR_NAME);
    car.move(ProbabilityUtil.ZERO_PERCENT);
    assertThat(car.getFinalPosition()).isEqualTo(INITIAL_POSITION);
    car.move(ProbabilityUtil.HUNDRED_PRECENT);
    assertThat(car.getFinalPosition()).isEqualTo(INITIAL_POSITION + MOVED_ONCE);
  }
}
