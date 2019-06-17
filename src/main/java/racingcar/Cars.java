package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
    getStream()
        .forEach(car -> car.move(RandomNumberGenerator.randomValue()));
  }

  private Stream<Car> getStream() {
    return cars.stream();
  }

  public Position position() {
    return new Position(
        getStream()
            .map(Car::getPosition)
            .collect(Collectors.toList()));
  }
}
