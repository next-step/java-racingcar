package racingcar.model;

import racingcar.strategy.MovingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

  private static final String BASIC_SPLIT_REGEX = ",";
  private static final String MINIMUM_NUMBER_OF_CAR_NAMES_INPUT_ERR_MSG = "자동차는 1대 이상 입력되어야 합니다.";

  private final List<Car> cars = new ArrayList<>();

  public Cars(MovingStrategy movingStrategy, String[] separateNames) {
    for (String separateName : separateNames) {
      cars.add(Car.create(movingStrategy, separateName));
    }
  }

  public static Cars create(MovingStrategy movingStrategy, String names) {
    String[] separateNames = separateInputCars(names);
    return new Cars(movingStrategy, separateNames);
  }

  public static String[] separateInputCars(String value) {
    checkTheNumberOfInputCars(value);
    return value.split(BASIC_SPLIT_REGEX);
  }

  public static void checkTheNumberOfInputCars(String value) {
    if (checkNullAndEmpty(value)) {
      throw new IllegalStateException(MINIMUM_NUMBER_OF_CAR_NAMES_INPUT_ERR_MSG);
    }
  }

  private static boolean checkNullAndEmpty(String value) {
    return (value == null || value.isEmpty());
  }

  public List<Car> getCars() {
    return cars;
  }

  public void runRace() {
    for (Car car : cars) {
      car.move();
    }
  }

  public List<String> getWinnerNames() {
    Car maxPositionCar = getMaxPositionCar();
    return cars.stream()
        .filter(car -> car.compareWithMaxPosition(maxPositionCar))
        .map(Car::getCarName)
        .collect(Collectors.toList());
  }

  private Car getMaxPositionCar() {
    return cars.stream()
        .max(Car::compareTo)
        .orElseThrow();
  }
}
