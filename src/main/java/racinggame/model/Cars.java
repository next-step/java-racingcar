package racinggame.model;

import racinggame.util.RandomValueUtil;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Cars {
  private final List<Car> cars;


  public Cars(String names) {
    cars = Stream.of(names.split(","))
                 .map(Car::new)
                 .collect(toList());
  }

  public Cars moveCars() {
    cars.forEach(car -> car.move(RandomValueUtil.getRandomValue()));
    return this;
  }

  public List<Integer> getCarsStatus() {
    return cars.stream()
               .map(Car::getStatus)
               .collect(toList());
  }
}
