package step3;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RacingCarTest {
  RacingCar racingCar = new RacingCar();

  @ParameterizedTest
  @CsvSource({"4, 1", "3, 0"})
  @DisplayName("입력받은 수에 따라 자동차 이동")
  void moveRacingCarByNumber(int nubmer, int expected) {
    
    racingCar.moveRacingCarByNumber(nubmer);
    assertThat(racingCar.getDistance()).isEqualTo(expected);
  }
}
