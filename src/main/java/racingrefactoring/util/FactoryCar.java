package racingrefactoring.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingrefactoring.domain.Car;

public class FactoryCar {
  private static final String DELIMITER = ",";

  public static List<Car> createCars(String carNames) {
    String[] names = splitCarNames(carNames);
    return createCars(names);
  }

  private static List<Car> createCars(String[] names) {
    return Arrays.stream(names).map(Car::new).collect(Collectors.toList());
  }

  private static String[] splitCarNames(String carNames) {
    return carNames.split(DELIMITER);
  }
}
