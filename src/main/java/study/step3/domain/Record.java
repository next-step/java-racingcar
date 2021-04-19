package study.step3.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Record {

  int times;

  public Record(int times) {
    this.times = times;
  }

  public String findWinners(List<Car> carList) {
    return carList.stream()
        .filter(car -> car.curPosition() == times)
        .map(Car::name)
        .collect(Collectors.joining(","));
  }

}
