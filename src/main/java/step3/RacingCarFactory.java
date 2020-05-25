package step3;

import java.util.ArrayList;
import java.util.List;

public class RacingCarFactory {
  private RacingCarFactory() {}

  public static List<Car> createRacingCarList(int numberOfCars) {
    List<Car> racingCarList = new ArrayList<>();

    for (int i = 0; i < numberOfCars; i++) {
      racingCarList.add(new RacingCar());
    }

    return racingCarList;
  }
}
