package racinggame.view;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.CsvSource;
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
  void printWinner(String carNameInput,
      @ConvertWith(PrintWinnerTimeArgumentConverter.class) int[] timeArr) {
    List<Car> racingCarList = new ArrayList<>();
    String[] carNameArr = carNameInput.split(" ");

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

    RacingGameResultView.printWinner(racingCarList);
  }

}

class PrintWinnerTimeArgumentConverter extends SimpleArgumentConverter {

  @Override
  protected int[] convert(Object source, Class<?> targetType)
      throws ArgumentConversionException {
    if (source instanceof String) {
      return Arrays.stream(((String) source).split(" "))
          .mapToInt(Integer::parseInt).toArray();
    }

    return null;
  }
}
