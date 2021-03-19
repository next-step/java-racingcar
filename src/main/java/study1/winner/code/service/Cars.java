package study1.winner.code.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
  private List<Car> cars;

  public Cars(List<Car> cars) {
    this.cars = cars;
  }

  public Cars(Cars cars) {
    this.cars = cars.cars.stream()
                  .map((car) -> new Car(car))
                  .collect(Collectors.toList());
  }

  public Cars move() {
    return new Cars(
      cars.stream()
      .map((car) -> car.move(new RaceMove()))
      .collect(Collectors.toList())
    );
	}

  public List<String> winners() {
    int maxDistance = maxDistance();
    return cars.stream()
      .filter((car) -> car.distance() == maxDistance)
      .map((car) -> car.driver())
      .collect(Collectors.toList());
  }

  public int maxDistance() {
    return cars.stream()
      .map((car) -> car.distance())
      .max(Integer::compare)
      .orElse(-1);
  }

}
