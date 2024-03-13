package racingcar.step3.domain;

import racingcar.step3.domain.strategy.RandomCarMoveStrategy;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

  public static final String NUMBER_OR_CARS_IS_INCORRECT = "차량 갯수가 올바르지 않습니다. input: %s";

  public static List<Car> of(int numberOfCars) {
    validateCount(numberOfCars);
    return manufacture(numberOfCars);
  }

  private static void validateCount(int numberOfCars) {
    if (numberOfCars <= 0) {
      throw new IllegalArgumentException(String.format(NUMBER_OR_CARS_IS_INCORRECT, numberOfCars));
    }
  }

  private static List<Car> manufacture(int numberOfCars) {
    List<Car> cars = new ArrayList<>();
    for (int i = 1; i <= numberOfCars; i++) {
      String carName = "car" + i;
      cars.add(new Car(carName, new RandomCarMoveStrategy()));
    }
    return cars;
  }
}
