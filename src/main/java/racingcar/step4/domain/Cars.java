package racingcar.step4.domain;

import racingcar.step4.domain.strategy.MoveNumberGenerator;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {

  private final List<Car> cars;

  public Cars(List<Car> cars) {
    this.cars = cars;
  }

  public void move(MoveNumberGenerator moveNumberGenerator) {
    for (Car car : cars) {
      car.move(moveNumberGenerator);
    }
  }

  public static Cars pickWinners(Cars candidates) {
    Car winnerCandidate = Collections.max(candidates.getCars());
    List<Car> cars = candidates.getCars().stream()
        .filter(car -> Objects.equals(car.getPosition().get(), winnerCandidate.getPosition().get()))
        .collect(Collectors.toList());

    return new Cars(cars);
  }

  public List<String> getWinnerNames() {
    return this.cars.stream()
        .map(it -> it.getCarName().get())
        .collect(Collectors.toList());
  }

  public List<Car> getCars() {
    return cars;
  }

  public Cars copyCars() {
    return new Cars(cars.stream().map(Car::copy).collect(Collectors.toList()));
  }

  public int size() {
    return cars.size();
  }
}
