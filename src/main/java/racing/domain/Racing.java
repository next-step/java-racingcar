package racing.domain;

import java.util.ArrayList;
import java.util.List;
import racing.RandomGenerator;

public class Racing {

  private final List<Car> cars = new ArrayList<>();

  public static Racing createRacing(String carNamesRaw) {
    return new Racing(StringToArray(carNamesRaw));
  }

  public Racing(String[] carNames) {
    generateCars(carNames);
  }

  private static String[] StringToArray(String carNamesRaw) {
    return carNamesRaw.split(",");
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

  public List<String> getMaxPosition() {
    List<String> maxPositionCars = new ArrayList<>();
    int maxPosition = 0;
    for (Car car : cars) {
      maxPosition = findMaxPosition(maxPosition, car);
    }
    for (Car car : cars) {
      addMaxPositionCar(maxPositionCars, maxPosition, car);
    }
    return maxPositionCars;
  }

  private void addMaxPositionCar(List<String> maxPositionCars, int maxPosition, Car car) {
    if (car.getPosition() == maxPosition) {
      maxPositionCars.add(car.getName());
    }
  }

  private int findMaxPosition(int maxPosition, Car car) {
    if (car.getPosition() > maxPosition) {
      maxPosition = car.getPosition();
    }
    return maxPosition;
  }
}
