package racinggame.view;


import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import racinggame.model.domain.Car;
import racinggame.model.domain.RacingCarFactory;

import racinggame.model.domain.RacingCarMovingStrategy;

public class RacingGameResultViewTest {

  @ParameterizedTest
  @CsvSource({"test1 test2, 20"})
  void printNameAndDistancesOfRacingCarList(String carNameInput, int time) {
    List<Car> racingCarList = RacingCarFactory.createRacingCarList(carNameInput.split(" "));

    for (int i = 0; i < time; i++) {
      for (Car racingCar : racingCarList) {
        racingCar.move();
      }
      RacingGameResultView.printNameAndDistancesOfRacingCarList(
          RacingCarFactory.createRacingCarDTOList(racingCarList));
    }
  }

  @ParameterizedTest
  @MethodSource("carNameWithTimeProvider")
  void printWinner(String[] carNameArr, int[] timeArr) {
    List<Car> racingCarList = new ArrayList<>();

    // racingCarList 초기화
    for (String s : carNameArr) {
      racingCarList.add(new Car(s, new RacingCarMovingStrategy() {
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

    for (int i = 0, endpoint = racingCarList.size(); i < endpoint; i++) {
      assertThat(racingCarList.get(i).getDistance()).isEqualTo(timeArr[i]);
    }
  }

  static Stream<Arguments> carNameWithTimeProvider() {
    return Stream.of(
        arguments(new String[]{"test1", "test2", "test3"}, new int []{0, 0, 1}),
        arguments(new String[]{"test1", "test2", "test3"}, new int []{2, 0, 1}),
        arguments(new String[]{"test1", "test2", "test3"}, new int []{2, 2, 1}),
        arguments(new String[]{"test1", "test2", "test3"}, new int []{2, 2, 2})
    );
  }

}
