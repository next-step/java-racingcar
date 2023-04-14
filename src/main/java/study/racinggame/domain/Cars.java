package study.racinggame.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
  private final List<Car> cars;

  public Cars(List<Car> cars) {
    this.cars = cars;
  }

  public void forwardCars() {
    cars.forEach(car -> car.forward(new RacingGameStrategy()));
  }

  public List<Car> cars() {
    return Collections.unmodifiableList(cars);
  }

  public List<String> carNamesAtSameDistance(int distance) {
    return cars().stream()
            .filter(car -> car.isSameDistance(distance))
            .map(Car::name)
            .collect(Collectors.toList());
  }

  public static Cars newInstance(List<String> carNames) {
    List<Car> cars = new ArrayList<>();

    for (String carName : carNames) {
      cars.add(new Car(carName));
    }

    return new Cars(cars);
  }

  public static Cars copyCars(Cars cars) {
    return new Cars(cars.cars().stream()
            .map(Cars::copyCar)
            .collect(Collectors.toList()));
  }

  private static Car copyCar(Car car) {
    return new Car(car.name(), car.distance());
  }
}
