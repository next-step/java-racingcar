package step3;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RacingCarTest {
  RacingCar racingCar = new RacingCar();

  @ParameterizedTest
  @CsvSource({"4, 1", "3, 0"})
  // @CsvSource({"1, 1, 4, 1", "2, 1, 4, 1", "1, 1, 3, 0", "2, 1, 3, 0"})
  void moveRacingCarByRandomNumber(int randomNubmer, int expected) {
    
    racingCar.moveRacingCarByRandomNumber(randomNubmer);
    assertThat(racingCar.getDistance()).isEqualTo(expected);
  }
}
