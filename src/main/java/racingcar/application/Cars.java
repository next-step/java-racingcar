package racingcar.application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {

  private final MoveStrategy moveStrategy;
  private final List<Car> cars;

  public Cars(MoveStrategy moveStrategy, int count) {
    this.moveStrategy = moveStrategy;
    this.cars = init(count);
  }

  public static Cars readyForRace(MoveStrategy moveStrategy, int count) {
    return new Cars(moveStrategy, count);
  }

  public void go() {
    cars.forEach(car -> car.go(moveStrategy));
  }

  public List<Integer> locationValues() {
    return cars.stream().map(car -> car.location())
        .collect(Collectors.toList());
  }

  private List<Car> init(int count) {
    List<Car> cars = new ArrayList<>();
    IntStream.rangeClosed(1, count)
        .forEach(number -> cars.add(new Car()));

    return cars;
  }
}
