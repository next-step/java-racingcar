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

  public String getWinner(int max) {
    return cars.stream()
               .filter(car -> car.getStatus() == max)
               .map(Car::getName)
               .collect(Collectors.joining(", "));
  }

  public int getMax() {
    return cars.stream()
               .mapToInt(Car::getStatus)
               .filter(car -> car >= 0)
               .max()
               .orElse(0);
  }
}
