package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class CarsTest {

  private static final int VALID_CAR_COUNT = 10;
  private static final int INVALID_CAR_COUNT = 0;
  private static final int VALID_INITIAL_POSITION = 0;
  private static final int MIN_NUMBER_TO_MOVE = 4;
  private static final int VALID_MAX_NUMBER = 10;
  private static final int INVALID_MAX_NUMBER = MIN_NUMBER_TO_MOVE - 1;

  private final Cars cars = new Cars(
      VALID_CAR_COUNT, VALID_INITIAL_POSITION, MIN_NUMBER_TO_MOVE
  );

  @Test
  void Cars_생성_실패() {
    assertThrows(IllegalArgumentException.class, () -> new Cars(
        INVALID_CAR_COUNT,
        VALID_INITIAL_POSITION,
        MIN_NUMBER_TO_MOVE
    ));
  }

  @Test
  void movaAllCar_실행_성공() {
    assertDoesNotThrow(() -> cars.moveAllCar(VALID_MAX_NUMBER));
  }

  @Test
  void movaAllCar_실행_실패() {
    assertThrows(IllegalArgumentException.class, () -> cars.moveAllCar(INVALID_MAX_NUMBER));
  }

  @Test
  void getPosition_실행_성공() {
    List<Integer> positions = cars.getPositions();
    List<Integer> result = positions.stream()
        .filter(position -> position >= VALID_INITIAL_POSITION)
        .collect(Collectors.toUnmodifiableList());
    assertThat(result.size()).isEqualTo(VALID_CAR_COUNT);
  }
}
