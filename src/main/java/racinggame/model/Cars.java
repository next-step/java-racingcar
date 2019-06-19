package racinggame.model;

import racinggame.util.RandomValueUtil;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Cars {
  private static final String SEPARATOR = ",";
  private final List<Car> cars;

  public Cars(String names) {
    cars = Stream.of(names.split(SEPARATOR))
                 .map(Car::new)
                 .collect(toList());
  }

  public Cars moveCars() {
    cars.forEach(car -> car.move(RandomValueUtil.getRandomValue()));
    return this;
  }

  public List<Car> getCars() {
    return cars;
  }

  public String getWinner() {
    int max = 0;
    for (Car car : cars) {
      if (max <= car.getStatus()) {
        max = car.getStatus();
      }
    }
    final int t = max;
    return cars.stream()
               .filter(c -> c.getStatus() == t)
               .map(Car::getName)
               .collect(Collectors.joining(", "));
  }
}
