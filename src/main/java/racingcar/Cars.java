package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Cars {

  private List<Car> cars = new ArrayList<>();

  public Cars(String[] carNames) {
    makeCars(carNames);
  }

  private void makeCars(String[] carNames) {
    for (int i = 0; i < carNames.length; i++) {
      cars.add(i, new Car(carNames[i]));
    }
  }

  public Position moveCars() {
    getStream()
        .forEach(car -> car.move(RandomNumberGenerator.randomValue()));
    return position();
  }

  private Stream<Car> getStream() {
    return cars.stream();
  }

  private Position position() {
    return new Position(
        getStream()
            .map(Car::getPosition)
            .collect(Collectors.toList()));
  }
}
