package racingCar;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class RacingCarTest {

  @ParameterizedTest
  @CsvSource(value = {"1,2,3:0", "5,8:1"}, delimiter = ':')
  public void moveRacingCarTest(String input, String expected) {
    String[] values = input.split(",");
    int expectedMoveCount = Integer.parseInt(expected);

    for (String value : values) {
      RacingCar car = new RacingCar(0);
      car.tryMove(Integer.parseInt(value));
      assertThat(car.getMoveCount()).isEqualTo(expectedMoveCount);
    }
  }
}
