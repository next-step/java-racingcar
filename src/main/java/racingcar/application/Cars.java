package racingcar.application;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.dto.CarNames;

public class Cars {

  private final MoveStrategy moveStrategy;
  private final List<Car> cars;

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
    return cars.stream().map(car -> car.location())
        .collect(Collectors.toList());
  }

  private List<Car> init(CarNames carNames) {
    List<Car> cars = new ArrayList<>();

    carNames.carNames()
            .forEach((name) -> cars.add(new Car(name)));

    return Collections.unmodifiableList(cars);
  }
}
