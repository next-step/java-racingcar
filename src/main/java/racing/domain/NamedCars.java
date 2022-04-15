package racing.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racing.domain.strategy.MoveStrategy;
import racing.domain.strategy.NameValidationStrategy;


public class NamedCars {

  public static final String CAR_NAME_DELIMITER = ",";
  private final List<NamedCar> namedCars;

  public NamedCars(List<NamedCar> namedCars) {
    this.namedCars = namedCars;
  }


  public List<String> getNames() {
    List<String> names = new ArrayList<>();
    for (NamedCar namedCar : namedCars) {
      names.add(namedCar.getCarName());
    }
    return names;
  }


  public void attempt() {
    for (NamedCar namedCar : namedCars) {
      namedCar.attempt();
    }
  }

  public List<Integer> getDistances() {
    List<Integer> distances = new ArrayList<>();
    for (Car c : namedCars) {
      distances.add(c.getDistance());
    }
    return distances;
  }

  public static NamedCars newInstance(String carNames,
      NameValidationStrategy nameValidationStrategy, MoveStrategy moveStrategy) {
    List<NamedCar> cars = Arrays.stream(carNames.split(CAR_NAME_DELIMITER))
        .map(n -> new NamedCar(new CarName(n, nameValidationStrategy), moveStrategy))
        .collect(Collectors.toList());

    return new NamedCars(cars);
  }
}
