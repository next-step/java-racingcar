package racing.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CarManager {

  private final List<Car> cars = new ArrayList<>();
  private final NumberGenerator numberGenerator;

  public CarManager(List<Car> cars) {
    this(cars, new RandomGenerator());
  }

  public CarManager(String[] carNames, NumberGenerator numberGenerator) {
    generateCars(carNames);
    this.numberGenerator = numberGenerator;
  }

  public CarManager(List<Car> cars, NumberGenerator numberGenerator) {
    this.cars.addAll(cars);
    this.numberGenerator = numberGenerator;
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
      car.driveOrStop(numberGenerator.generate());
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
