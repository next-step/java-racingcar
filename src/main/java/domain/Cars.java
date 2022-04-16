package domain;

import static util.Validator.validateArgument;
import static util.RandomNumberGenerator.generate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

  private static final int MIN_CAR_COUNT = 1;

  private final int minNumberToMove;
  private final List<Car> cars;

  public Cars(int carCount, int initialPosition, int minNumberToMove) {
    validateCarCount(carCount);
    this.minNumberToMove = minNumberToMove;
    cars = new ArrayList<>();
    for (int i = 0; i < carCount; i++) {
      cars.add(new Car(initialPosition, minNumberToMove));
    }
  }

  public void moveAllCar(int maxNumber) {
    validateMaxRandomNumber(maxNumber);
    cars.forEach(car -> car.move(generate(maxNumber)));
  }

  public List<Integer> getPositions() {
    return cars.stream().map(Car::getPosition).collect(Collectors.toUnmodifiableList());
  }

  private void validateCarCount(int carCount) {
    validateArgument(
        carCount,
        (arg) -> arg >= MIN_CAR_COUNT,
        String.format("차 갯수는 %d대 이상이어야 합니다.", MIN_CAR_COUNT)
    );
  }

  private void validateMaxRandomNumber(int maxNumber) {
    validateArgument(
        maxNumber,
        (arg) -> arg > minNumberToMove,
        "최대 랜덤 숫자는 움직일 수 있는 숫자보다 커야합니다.");
  }
}
