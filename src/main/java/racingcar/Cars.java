package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

  private List<Car> cars = new ArrayList<>();

  public Cars(int numberOfCar) {
    makeCars(numberOfCar);
  }

  private void makeCars(int numberOfCar) {
    for (int i = 0; i < numberOfCar; i++) {
      cars.add(i, new Car());
    }
  }

  public void moveCars() {
    cars.stream()
        .forEach(car -> car.move(RandomNumberGenerator.randomValue()));
  }

  public List<Integer> getCarsPosition() {
    return cars.stream()
        .map(Car::getPosition)
        .collect(Collectors.toList());
  }
}
