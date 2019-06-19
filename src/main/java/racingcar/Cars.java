package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

  private List<Car> cars;

  public Cars(String[] carNames) {
    cars = makeCars(carNames);
  }

  private List<Car> makeCars(String[] carNames) {
    return Arrays.stream(carNames)
        .map(Car::new)
        .collect(Collectors.toList());
  }

  public List<Car> moveCars() {
    cars.stream()
        .forEach(car -> car.move(RandomNumberGenerator.randomValue()));
    return cars;
  }

  public List<Car> getCars() {
    return cars;
  }

}
