package racingCar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
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
      RacingCar car = new RacingCar(0, getCarName(Integer.parseInt(value)));
      car.tryMove(Integer.parseInt(value));
      assertThat(car.getMoveCount()).isEqualTo(expectedMoveCount);
    }
  }

  @ParameterizedTest
  @CsvSource(value = {"1,2,2:false,true,true", "3,4,5:false,false,true"}, delimiter = ':')
  public void getWinner(String input, String expected) {
    String[] moveCounts = input.split(",");
    String[] expectedWinner = expected.split(",");

    RacingCars racingCars = new RacingCars(new ArrayList<>());
    for (int i = 0; i < moveCounts.length; i++) {
      RacingCar car = new RacingCar(Integer.parseInt(moveCounts[i]), getCarName(i));
      racingCars.add(car);
    }

    for (int i = 0; i < expectedWinner.length; i++) {
      boolean isWinner = Boolean.parseBoolean(expectedWinner[i]);
      assertThat(racingCars.getWinnerNames().contains(getCarName(i))).isEqualTo(isWinner);
    }
  }

  private String getCarName(int carNumber) {
    return String.format("car%s", carNumber);
  }
}
