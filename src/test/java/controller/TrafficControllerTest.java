package controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import model.CarCount;
import org.junit.jupiter.api.Test;

public class TrafficControllerTest {

  private static final int VALID_CAR_COUNT = 10;
  private static final int VALID_TRY_COUNT = 5;
  private static final int INVALID_TRY_COUNT = 0;

  @Test
  void init_수행_검사() {
    assertThat(TrafficController.init()).isNotNull();
  }

  @Test
  void tryCount_올바른_값() {
    assertDoesNotThrow(() -> TrafficController.init()
        .tryCount(VALID_TRY_COUNT));
  }

  @Test
  void tryCount_잘못된_값() {
    assertThrows(IllegalArgumentException.class, () -> TrafficController.init()
        .tryCount(INVALID_TRY_COUNT)
    );
  }

  @Test
  void createCar_수행_성공() {
    assertDoesNotThrow(() -> TrafficController.init()
        .createCars(new CarCount(VALID_CAR_COUNT))
        .tryCount(VALID_TRY_COUNT)
        .start()
    );
  }

  @Test
  void createCar_수행_실패() {
    assertThrows(NullPointerException.class, () -> TrafficController.init()
        .createCars(new CarCount(VALID_CAR_COUNT))
        .start()
    );
  }

  @Test
  void start_실행_성공() {
    assertDoesNotThrow(() -> TrafficController.init()
        .createCars(new CarCount(VALID_CAR_COUNT))
        .tryCount(VALID_TRY_COUNT)
        .start()
    );
  }

  @Test
  void start_실행_실패() {
    assertThrows(NullPointerException.class, () -> TrafficController.init()
        .start());
  }
}
