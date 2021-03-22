package racingCar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

  private List<Car> cars;

  public Cars(String[] cars) {
    this.cars = makeCars(cars);
  }

  public Cars(List<Car> cars) {
    this.cars = cars;
  }

  public List<TryResult> move() {
    List<TryResult> tryResults = new ArrayList<>();
    for (Car car : cars) {
      tryResults.add(car.move(new RandomMovable()));
    }
    return tryResults;
  }

  private List<Car> makeCars(String[] carNames) {
    List<Car> carList = new ArrayList<>();
    for (int i = 0; i < carNames.length; i++) {
      carList.add(new Car(carNames[i], 0));
    }
    return carList;
  }

  public List<Car> determineWinners() {
    int max = getMaxPosition(cars);

    return cars.stream()
        .filter(car -> car.getPosition() == max)
        .collect(Collectors.toList());
  }

  private int getMaxPosition(List<Car> cars) {
    return cars.stream()
        .mapToInt(Car::getPosition)
        .max()
        .orElse(-1);
  }

  public int size() {
    return cars.size();
  }

  public Car getCar(int index) {
    return cars.get(index);
  }

  public String getWinnerNames() {
    return cars.stream()
        .map(Car::getName)
        .collect(Collectors.joining(","));
  }
}
