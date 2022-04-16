package domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CarsTest {

  private static final int VALID_CAR_COUNT = 10;
  private static final int INVALID_CAR_COUNT = 0;
  private static final int INITIAL_POSITION = 0;
  private static final int NUMBER_ABLE_TO_MOVE = 4;
  private static final int NUMBER_UNABLE_TO_MOVE = 3;

  private Cars cars;

  @BeforeEach
  void setup() {
    cars = new Cars(VALID_CAR_COUNT);
  }

  @Test
  void Cars_생성_성공() {
    assertDoesNotThrow(() -> new Cars(VALID_CAR_COUNT));
  }

  @Test
  void Cars_생성_실패() {
    assertThrows(IllegalArgumentException.class, () -> new Cars(INVALID_CAR_COUNT));
  }
}
