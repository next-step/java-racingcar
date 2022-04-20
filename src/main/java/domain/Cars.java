package domain;

import static util.RandomNumberGenerator.generateRandomNumberInRange;
import static util.Validator.validateArgument;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class Cars {

  private static final int MIN_CAR_COUNT = 1;

  private final List<Car> cars;

  public Cars(List<String> carNames) {
    validateCarNames(carNames);
    cars = new ArrayList<>();
    for (String carName : carNames) {
      cars.add(new Car(carName));
    }
  }

  public void moveAllCarRandomly(int randomNumberBound) {
    cars.forEach(car -> car.move(generateRandomNumberInRange(randomNumberBound)));
  }

  public List<CarInfo> getCarsInfo() {
    return cars.stream()
        .map(Car::getCarInfo)
        .collect(Collectors.toUnmodifiableList());
  }

  public List<String> findWinners() {
    final int winnerPosition = cars.stream()
        .map(Car::getCarInfo)
        .max(CarInfo::compareTo)
        .orElseThrow(NoSuchElementException::new)
        .getPositionOfCar();

    return cars.stream()
        .map(Car::getCarInfo)
        .filter((carInfo) -> carInfo.getPositionOfCar() == winnerPosition)
        .map(CarInfo::getNameOfCar)
        .collect(Collectors.toUnmodifiableList());
  }

  private void validateCarNames(List<String> carNames) {
    validateCarCount(carNames.size());
  }

  private void validateCarCount(int carCount) {
    validateArgument(
        carCount,
        (arg) -> arg >= MIN_CAR_COUNT,
        String.format("차 갯수는 %d대 이상이어야 합니다.", MIN_CAR_COUNT)
    );
  }
}
