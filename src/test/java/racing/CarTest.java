package racing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.MovingStrategy.AlwaysMovingStrategy;
import racing.MovingStrategy.NeverMovingStrategy;

public class CarTest {

  public static final int START_LOCATION = 1;
  public static final int DISTANCE_TO_MOVE_AT_ONCE = 1;
  public static final String CAR_NAME = "Tonny";
  public static final String LONG_CAR_NAME = "Lamborghini";


  private static Car car;

  @BeforeEach
  void setUp() {
    car = new Car(CAR_NAME);
  }

  @Test
  void initialLocation() {
    assertThat(car.getLocation()).isEqualTo(START_LOCATION);
  }

  @Test
  @DisplayName("자동차를 한칸 이동시킨다")
  void moveOnce() {
    int carLastLocation = car.getLocation();
    car.move();
    assertThat(car.getLocation()).isEqualTo(carLastLocation + DISTANCE_TO_MOVE_AT_ONCE);
  }

  @Test
  @DisplayName("자동차가 이동 가능하면 이동시킨다")
  void moveOnceIfMovable() {
    car.setMovingStrategy(new AlwaysMovingStrategy());
    int carLastLocation = car.getLocation();

    car.moveIfMovable();
    assertThat(car.getLocation()).isEqualTo(carLastLocation + DISTANCE_TO_MOVE_AT_ONCE);
  }

  @Test
  @DisplayName("자동차가 이동 불가능하면 그대로 있는다")
  void moveNeverIfNoMovable() {
    car.setMovingStrategy(new NeverMovingStrategy());
    int carLastLocation = car.getLocation();

    car.moveIfMovable();
    assertThat(car.getLocation()).isEqualTo(carLastLocation);
  }

  @Test
  @DisplayName("Exception 체크")
  void nameMoreThanFiveChar() {
    RuntimeException exception = assertThrows(RuntimeException.class, () -> new Car(LONG_CAR_NAME));

    assertEquals("이름은 5글자 이하로 입력해주세요.", exception.getMessage());
  }
}
