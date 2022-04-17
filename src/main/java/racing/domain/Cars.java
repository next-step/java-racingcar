package racing.domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racing.domain.strategy.MoveStrategy;


public class Cars {

  public static final String CAR_NAME_DELIMITER = ",";
  private final List<Car> values;

  public Cars(List<Car> values) {
    this.values = values;
  }

  public static Cars newInstance(String carNames, MoveStrategy moveStrategy) {
    List<Car> cars = Arrays.stream(carNames.split(CAR_NAME_DELIMITER))
        .map(carName -> new Car(carName, moveStrategy))
        .collect(toList());

    return new Cars(cars);
  }

  public List<String> getNames() {
    return values
        .stream()
        .map(Car::getCarName)
        .collect(Collectors.toList());
  }

  public List<Integer> getDistances() {
    return values
        .stream()
        .map(Car::getDistance)
        .collect(Collectors.toList());
  }

  public void attempt() {
    for (Car car : values) {
      car.attempt();
    }
  }

  public List<Car> getValues() {
    return values;
  }

  public Cars getWinners() {
    int max = getDistances()
        .stream()
        .max(Integer::compareTo)
        .orElseThrow();

    return values
        .stream()
        .filter(car -> car.getDistance() == max)
        .collect(collectingAndThen(toList(), Cars::new));
  }
}
