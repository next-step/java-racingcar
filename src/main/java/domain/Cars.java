package domain;

import static util.RandomNumberGenerator.generateRandomNumberInRange;
import static util.Validator.validateArgument;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

  private static final int MIN_CAR_COUNT = 1;

  private final List<Car> cars;

  public Cars(int carCount) {
    validateCarCount(carCount);
    cars = new ArrayList<>();
    for (int i = 0; i < carCount; i++) {
      cars.add(new Car());
    }
  }

  public void moveAllCarRandomly(int randomNumberBound) {
    cars.forEach(car -> car.move(generateRandomNumberInRange(randomNumberBound)));
  }

  public List<Integer> getPositions() {
    return cars.stream()
        .map(Car::getPosition)
        .collect(Collectors.toUnmodifiableList());
  }

  public void validate() {
    validateCarCount(cars.size());
  }

  private void validateCarCount(int carCount) {
    validateArgument(
        carCount,
        (arg) -> arg >= MIN_CAR_COUNT,
        String.format("차 갯수는 %d대 이상이어야 합니다.", MIN_CAR_COUNT)
    );
  }
}
