package carracing;

import carracing.model.Car;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
  private static final int MOVING_COUNT = 10;
  private static final int INITIAL_POSITION = 0;
  private static final int MOVED_ONCE = 1;

  @Test
  public void moveTest() {
    Car car = new Car();

    for (int i = 0; i < MOVING_COUNT; i++) {
      car.move();
    }

    assertThat(car.getPosition()).isBetween(INITIAL_POSITION, MOVING_COUNT);
  }

  @Test
  public void moveIfTest() {
    Car car = new Car();
    car.moveIf(false);
    assertThat(car.getPosition()).isEqualTo(INITIAL_POSITION);
    car.moveIf(true);
    assertThat(car.getPosition()).isEqualTo(MOVED_ONCE);
  }
}
