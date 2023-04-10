package racingcar.application;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {

  private final Accelerator accelerator;
  private final List<Car> cars;

  public Cars(Accelerator accelerator, int count) {
    this.accelerator = accelerator;
    this.cars = init(count);
  }

  public void go() {
    cars.forEach(car -> car.go());
  }

  public List<Integer> locationValues() {
    return cars.stream().map(car -> car.location())
        .collect(Collectors.toList());
  }

  private List<Car> init(int count) {
    List<Car> cars = new ArrayList<>();
    IntStream.rangeClosed(1, count)
        .forEach(number -> cars.add(new Car(accelerator)));

    return cars;
  }
}
