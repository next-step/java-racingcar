package domain;

import static util.RandomNumberGenerator.generateRandomNumberInRange;
import static util.Validator.validateArgument;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {

  private static final String CAR_RAW_NAMES_DELIMITER = ",";
  private static final int MIN_CAR_COUNT = 1;

  private final List<Car> cars;


  public Cars(List<Car> cars) {
    validateCarCount(cars.size());
    this.cars = cars;
  }

  public void moveAllCar(int moveNumberBound) {
    cars.forEach(car -> car.move(generateRandomNumberInRange(moveNumberBound)));
  }

  public Winners findWinners() {
    Car winner = cars.stream()
        .max(Car::compareTo)
        .orElseThrow();

    return new Winners(cars.stream()
        .filter((car) -> car.compareTo(winner) == 0)
        .map(Car::toString)
        .collect(Collectors.toUnmodifiableList()));
  }

  public List<String> markingPositions() {
    return cars.stream()
        .map(Car::markPosition)
        .collect(Collectors.toUnmodifiableList());
  }

  public static Cars fromString(String text) {
    Objects.requireNonNull(text);
    List<String> carNames = splitCarNames(text);
    List<Car> cars = new ArrayList<>();
    for (String carName : carNames) {
      cars.add(new Car(carName));
    }
    return new Cars(cars);

  }

  private static List<String> splitCarNames(String text) {
    return Stream.of(text.split(CAR_RAW_NAMES_DELIMITER))
        .collect(Collectors.toUnmodifiableList());
  }

  private void validateCarCount(int carCount) {
    validateArgument(
        carCount,
        (arg) -> arg >= MIN_CAR_COUNT,
        String.format("차 갯수는 %d대 이상이어야 합니다.", MIN_CAR_COUNT)
    );
  }
}
