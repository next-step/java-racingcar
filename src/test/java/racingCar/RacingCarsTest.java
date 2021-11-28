package racingCar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racingCar.model.Name;
import racingCar.model.RacingCar;
import racingCar.model.RacingCars;

class RacingCarsTest {

  @DisplayName("Test move racing cars.")
  @ParameterizedTest
  @CsvSource(value = {"1,2,3:0", "5,8:1"}, delimiter = ':')
  public void moveRacingCarTest(String input, String expected) {
    String[] values = input.split(",");
    int expectedPosition = Integer.parseInt(expected);

    for (int i = 0; i < values.length; i++) {
      int position = Integer.parseInt(values[i]);
      RacingCar car = new RacingCar(generateCarName(i));
      car.tryMove(position);
      assertEquals(car.getPosition().getValue(), expectedPosition);
    }
  }

  @DisplayName("Test find winner.")
  @ParameterizedTest
  @CsvSource(value = {"1,2,2:false,true,true", "3,4,5:false,false,true"}, delimiter = ':')
  public void findWinner(String input, String expected) {
    String[] positions = input.split(",");
    String[] expectedWinner = expected.split(",");

    List<RacingCar> initRacingCars = new ArrayList<>();
    for (int i = 0; i < positions.length; i++) {
      int position = Integer.parseInt(positions[i]);
      initRacingCars.add(new RacingCar(position, generateCarName(i)));
    }

    RacingCars winners = new RacingCars(initRacingCars).determineWinners();
    List<Name> winnerNames = winners.getAllCars().stream()
        .map(RacingCar::getName)
        .collect(Collectors.toList());

    for (int i = 0; i < expectedWinner.length; i++) {
      boolean isWinner = Boolean.parseBoolean(expectedWinner[i]);
      assertThat(winnerNames.contains(new Name(generateCarName(i)))).isEqualTo(isWinner);
    }
  }

  private String generateCarName(int carNumber) {
    return String.format("car%s", carNumber);
  }
}
