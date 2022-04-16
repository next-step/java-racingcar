package racing.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racing.domain.strategy.MoveStrategy;


public class Cars {

  public static final String CAR_NAME_DELIMITER = ",";
  private final List<Car> namedCars;

  public Cars(List<Car> namedCars) {
    this.namedCars = namedCars;
  }

  public List<String> getNames() {
    List<String> names = new ArrayList<>();
    for (Car namedCar : namedCars) {
      names.add(namedCar.getCarName());
    }
    return names;
  }

  public List<Integer> getDistances() {
    List<Integer> distances = new ArrayList<>();
    for (Car c : namedCars) {
      distances.add(c.getDistance());
    }
    return distances;
  }

  public List<Car> getNamedCars() {
    return namedCars;
  }

  public void attempt() {
    for (Car namedCar : namedCars) {
      namedCar.attempt();
    }
  }

  public static Cars newInstance(String carNames, MoveStrategy moveStrategy) {
    List<Car> cars = Arrays.stream(carNames.split(CAR_NAME_DELIMITER))
        .map(n -> new Car(n, moveStrategy))
        .collect(Collectors.toList());

    return new Cars(cars);
  }

}
