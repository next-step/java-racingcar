package racing.domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racing.domain.strategy.MoveStrategy;


public class Cars {

  public static final String CAR_NAME_DELIMITER = ",";
  private final List<Car> values;

  public Cars(List<Car> values) {
    this.values = values;
  }

  public List<String> getNames() {
    List<String> names = new ArrayList<>();
    for (Car car : values) {
      names.add(car.getCarName());
    }
    return names;
  }

  public List<Integer> getDistances() {
    List<Integer> distances = new ArrayList<>();
    for (Car c : values) {
      distances.add(c.getDistance());
    }
    return distances;
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

  public static Cars newInstance(String carNames, MoveStrategy moveStrategy) {
    List<Car> cars = Arrays.stream(carNames.split(CAR_NAME_DELIMITER))
        .map(n -> new Car(n, moveStrategy))
        .collect(toList());

    return new Cars(cars);
  }

}
