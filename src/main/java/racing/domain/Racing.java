package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racing.RandomGenerator;

public class Racing {

  private final List<Car> cars = new ArrayList<>();

  public Racing(String[] carNames) {
    generateCars(carNames);
  }

  public Racing(List<Car> cars) {
    this.cars.addAll(cars);
  }

  private List<Car> generateCars(String[] carNames) {
    for (String carName : carNames) {
      cars.add(new Car(carName));
    }
    return cars;
  }

  public List<Car> getCars() {
    return cars;
  }

  public void simulateRace() {
    for (Car car : cars) {
      car.driveOrStop(RandomGenerator.generate());
    }
  }

  public List<String> findWinners() {
    int maxPosition = calculateMaxPosition();


    return findMaxPosition(maxPosition);
  }

  private int calculateMaxPosition() {
    return cars.stream()
        .mapToInt(Car::getPosition)
        .max()
        .getAsInt();
  }

  private List<String> findMaxPosition(int maxPosition) {
    return cars.stream()
        .filter(car -> car.getPosition() == maxPosition)
        .map(Car::getName)
        .collect(Collectors.toList());
  }
}
