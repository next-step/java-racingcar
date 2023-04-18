package racingcar.application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarNames;

public class Cars {

  private final MoveStrategy moveStrategy;
  private final List<Car> cars;
  private final Comparator<Car> comparatorByLocation = Comparator.comparingInt(Car::location);


  public Cars(MoveStrategy moveStrategy, CarNames carNames) {
    this.moveStrategy = moveStrategy;
    this.cars = init(carNames);
  }

  public static Cars readyForRace(MoveStrategy moveStrategy, CarNames carNames) {
    return new Cars(moveStrategy, carNames);
  }

  public void go() {
    cars.forEach(car -> car.go(moveStrategy));
  }

  public List<String> locationValues() {
    return cars.stream()
        .map(car -> car.progress())
        .collect(Collectors.toList());
  }

  public List<String> winnerName() {
    int max = cars.stream()
        .max(comparatorByLocation)
        .orElseThrow(IllegalArgumentException::new)
        .location();

    return cars.stream()
        .filter(car -> car.location() == max)
        .map(car -> car.carName())
        .collect(Collectors.toList());
  }

  private List<Car> init(CarNames carNames) {
    List<Car> cars = new ArrayList<>();

    carNames.carNames()
            .forEach((name) -> cars.add(new Car(name)));

    return Collections.unmodifiableList(cars);
  }
}
