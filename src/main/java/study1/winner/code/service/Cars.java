package study1.winner.code.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import study1.winner.code.dto.ResultData;

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

  public List<ResultData> result() {
    return cars.stream()
      .map(car -> new ResultData(car.driver(), car.distance()))
      .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
  }

  public List<String> winners() {
    int maxDistance = maxDistance();
    return cars.stream()
      .filter((car) -> car.isWinner(maxDistance))
      .map((car) -> car.driver())
      .collect(Collectors.toList());
  }

  public int maxDistance() {
    return cars.stream()
      .map((car) -> car.distance())
      .max(Integer::compare)
      .orElseThrow(() -> new IllegalArgumentException("최대 이동거리는 0 보다 작을수 없습니다."));
  }

}
