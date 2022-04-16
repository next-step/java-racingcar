import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CarTest {

  private static final int VALID_INITIAL_POSITION = 0;
  private static final int INVALID_INITIAL_POSITION = -3;
  private static final int MIN_NUMBER_TO_MOVE = 4;

  @Test
  void Car_생성_성공() {
    assertDoesNotThrow(() -> new Car(VALID_INITIAL_POSITION, MIN_NUMBER_TO_MOVE));
  }

  @Test
  void Car_생성_실패() {
    assertThrows(IllegalArgumentException.class, () -> new Car(
        INVALID_INITIAL_POSITION,
        MIN_NUMBER_TO_MOVE
    ));
  }

  @Test
  void getPosition_성공() {
    Car car = new Car(VALID_INITIAL_POSITION, MIN_NUMBER_TO_MOVE);
    car.move(MIN_NUMBER_TO_MOVE);
    assertThat(car.getPosition()).isEqualTo(1);
  }
}
