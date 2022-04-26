package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CarPositionTest {

  private static final String POSITION_MARKER = "-";
  private static final int VALID_CAR_POSITION = 1;
  private static final int INVALID_CAR_POSITION = -1;

  @Test
  void add_성공() {
    CarPosition carPosition = new CarPosition(0);
    carPosition.add(5);
    CarPosition expected = new CarPosition(5);

    assertThat(carPosition.compareTo(expected)).isEqualTo(0);
  }

  @Test
  void CarPosition_생성_성공() {
    assertDoesNotThrow(() -> new CarPosition(VALID_CAR_POSITION));
  }

  @Test
  void CarPosition_생성_실패() {
    assertThrows(IllegalArgumentException.class, () -> new CarPosition(INVALID_CAR_POSITION));
  }

  @Test
  void toString_성공() {
    CarPosition carPosition = new CarPosition(VALID_CAR_POSITION);
    String positionMark = carPosition.toString();
    assertThat(positionMark).isEqualTo(POSITION_MARKER);
  }
}
