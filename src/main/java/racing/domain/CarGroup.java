package racing.domain;

import java.util.List;

public class CarGroup {

  private final List<Car> cars;

  public CarGroup(String carsName) {
    cars = CarFactory.createCars(carsName);
  }

  public void moveCars(MoveStrategy moveStrategy) {
    cars.forEach(car -> car.move(moveStrategy));
  }

  public List<Car> getCars() {
    return cars;
  }

  public String[] findWinners() {
    int maxPosition = findMaxPosition();
    return cars.stream()
        .filter(car -> isWinner(maxPosition, car))
        .map(Car::name)
        .toArray(String[]::new);
  }

  private boolean isWinner(int maxPosition, Car car) {
    return car.position() == maxPosition;
  }

  private int findMaxPosition() {
    return cars.stream()
        .mapToInt(Car::position)
        .max()
        .orElse(0);
  }
}
