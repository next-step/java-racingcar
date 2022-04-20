package racing.domain;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import racing.domain.strategy.MoveStrategy;


public class Cars {

  private final List<Car> values;

  public Cars(List<Car> values) {
    this.values = values;
  }

  public static Cars newInstance(String carNames) {
    return new Cars(Arrays.stream(carNames.split(","))
        .map(carName -> new Car(carName))
        .collect(Collectors.toList()));
  }

  public static Cars newInstance(String carNames, Distance distance) {
    return new Cars(Arrays.stream(carNames.split(","))
        .map(carName -> new Car(carName, distance))
        .collect(Collectors.toList()));
  }

  public List<String> getNames() {
    return values
        .stream()
        .map(Car::getCarName)
        .collect(Collectors.toList());
  }

  public void attempt(MoveStrategy moveStrategy) {
    for (Car car : values) {
      car.attempt(moveStrategy);
    }
  }

  public List<Car> getValues() {
    return values;
  }

  public Cars getWinners() {
    Distance max = getMaxDistance();

    return values
        .stream()
        .filter(car -> car.isDistanceEqual(max))
        .collect(collectingAndThen(toList(), Cars::new));
  }

  private Distance getMaxDistance() {
    Distance maxDistance = new Distance();
    for (Car car : values) {
      maxDistance = car.getMaxDistance(maxDistance);
    }
    return maxDistance;
  }

  public boolean matchDistances(List<Distance> distances) {
    if (values.size() != distances.size()) {
      return false;
    }

    for (int i = 0; i < distances.size(); i++) {
      if (!values.get(i).isDistanceEqual(distances.get(i))) {
        return false;
      }
    }
    return true;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Cars)) {
      return false;
    }
    Cars cars = (Cars) o;
    return Objects.equals(values, cars.values);
  }

}
