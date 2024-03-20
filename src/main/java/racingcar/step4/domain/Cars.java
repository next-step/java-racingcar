package racingcar.step4.domain;

import racingcar.step4.domain.strategy.MoveNumberGenerator;

import java.util.Collections;
import java.util.List;
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

  public Cars pickWinners() {
    Car winnerCandidate = Collections.max(cars);
    List<Car> winners = cars.stream()
        .filter(winnerCandidate::findSamePosition)
        .collect(Collectors.toList());

    return new Cars(winners);
  }

  // dto 컨버팅 용도로만 사용
  public List<String> getWinnerNames() {
    return this.cars.stream()
        .map(Car::getCarName)
        .collect(Collectors.toList());
  }

  public Cars copyCars() {
    return new Cars(cars.stream().map(Car::copy).collect(Collectors.toList()));
  }

  public int size() {
    return cars.size();
  }

  // dto 컨버팅, 테스트 용으로만 사용
  public List<Car> getCars() {
    return cars;
  }
}
