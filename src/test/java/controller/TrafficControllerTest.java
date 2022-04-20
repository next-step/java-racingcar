package controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.StringJoiner;
import java.util.stream.Stream;
import model.CarPosition;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ValueSource;

public class TrafficControllerTest {

  private static final String CAR_NAMES_DELIMITER = ",";
  private static final String CAR_NAME_1 = "name1";
  private static final String CAR_NAME_2 = "name2";
  private static final String CAR_NAME_3 = "name3";
  private static final String CAR_NAME_4 = "name4";
  private static final String CAR_NAME_5 = "name5";
  private static final String VALID_RAW_CAR_NAMES = new StringJoiner(CAR_NAMES_DELIMITER)
      .add(CAR_NAME_1)
      .add(CAR_NAME_2)
      .add(CAR_NAME_3)
      .add(CAR_NAME_4)
      .add(CAR_NAME_5)
      .toString();
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
        .createCars(VALID_RAW_CAR_NAMES)
        .tryCount(VALID_TRY_COUNT)
        .start()
    );
  }

  @ParameterizedTest
  @ValueSource(strings = {"", " , ", "여섯글자이름, 다섯자이름"})
  void createCar_수행_실패(String invalidNRawCarNames) {
    assertThrows(IllegalArgumentException.class, () -> TrafficController.init()
        .createCars(invalidNRawCarNames)
        .start()
    );
  }

  @Test
  void start_실행_성공() {
    assertDoesNotThrow(() -> TrafficController.init()
        .createCars(VALID_RAW_CAR_NAMES)
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
