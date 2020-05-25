package step3;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class RacingGameResultViewTest {
  @Test
  void printResultMessage() {
    RacingGameResultView.printDistance(5);
  }

  @ParameterizedTest
  @CsvSource({"3, 20"})
  void printDistancesOfRacingCarList(int numberOfCars, int time) {
    List<Car> racingCarList = RacingCarFactory.createRacingCarList(numberOfCars);

    for (int i = 0; i < time; i++) {
      for (Car racingCar : racingCarList) {
        racingCar.move();
      }
      RacingGameResultView.printDistancesOfRacingCarList(racingCarList);
    }

  }
}
