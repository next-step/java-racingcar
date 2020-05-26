package step3;

import java.util.ArrayList;
import java.util.Arrays;
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

  @ParameterizedTest
  @CsvSource({"test1 test2, 20"})
  void printNameAndDistancesOfRacingCarList(String carNameInput, int time) {
    List<Car> racingCarList = RacingCarFactory.createRacingCarList(carNameInput.split(" "));

    for (int i = 0; i < time; i++) {
      for (Car racingCar : racingCarList) {
        racingCar.move();
      }
      RacingGameResultView.printNameAndDistancesOfRacingCarList(racingCarList);
    }
  }

  @ParameterizedTest
  @CsvSource({
    "test1 test2 test3, 0 0 1", 
    "test1 test2 test3, 2 0 1", 
    "test1 test2 test3, 2 2 1",
    "test1 test2 test3, 2 2 2"
    })
  void printWinner(String carNameInput, String timeInput) {
    List<Car> racingCarList = new ArrayList<>();
    String[] carNameArr = carNameInput.split(" ");
    int[] timeArr = Arrays.stream(timeInput.split(" "))
        .mapToInt(timeStr -> Integer.parseInt(timeStr)).toArray();

    // racingCarList 초기화
    for (int i = 0; i < carNameArr.length; i++) {
      racingCarList.add(new Car(carNameArr[i], new RacingCarMovingStrategy() {
        @Override
        public boolean isCanMove() {
          return true;
        }
      }));
    }

    // racingCarList 이동
    for (int i = 0; i < timeArr.length; i++) {
      for (int j = 0; j < timeArr[i]; j++) {
        racingCarList.get(i).move();
      }
    }

    RacingGameResultView.printWinner(racingCarList);
  }
}
