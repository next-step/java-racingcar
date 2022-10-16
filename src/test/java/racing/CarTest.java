package racing;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.MovingStrategy.AlwaysMovingStrategy;
import racing.MovingStrategy.NeverMovingStrategy;

public class CarTest {

  public static final int START_LOCATION = 1;
  public static final int DISTANCE_TO_MOVE_AT_ONCE = 1;


  private static Car car;

  @BeforeEach
  void setUp() {
    car = new Car();
  }

  @Test
  void initialLocation() {
    assertThat(car.nowLocation()).isEqualTo(START_LOCATION);
  }

  @Test
  @DisplayName("자동차를 한칸 이동시킨다")
  void moveOnce() {
    int carLastLocation = car.nowLocation();
    car.move();
    assertThat(car.nowLocation()).isEqualTo(carLastLocation + DISTANCE_TO_MOVE_AT_ONCE);
  }

  @Test
  @DisplayName("자동차가 이동 가능하면 이동시킨다")
  void moveOnceIfMovable() {
    car.setMovingStrategy(new AlwaysMovingStrategy());
    int carLastLocation = car.nowLocation();

    car.moveIfMovable();
    assertThat(car.nowLocation()).isEqualTo(carLastLocation + DISTANCE_TO_MOVE_AT_ONCE);
  }

  @Test
  @DisplayName("자동차가 이동 불가능하면 그대로 있는다")
  void moveNeverIfNoMovable() {
    car.setMovingStrategy(new NeverMovingStrategy());
    int carLastLocation = car.nowLocation();

    car.moveIfMovable();
    assertThat(car.nowLocation()).isEqualTo(carLastLocation);
  }
}
