package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

  private final List<Car> values;

  public Cars(List<Car> cars) {
    this.values = cars;
  }

  public List<Car> getValues() {
    return values;
  }

  public void move(List<Integer> randomNumbers) {
    int size = randomNumbers.size();
    if (size != values.size()) {
      throw new RuntimeException("실행 중 오류가 발생했습니다.");
    }
    for (int i = 0; i < size; i++) {
      values.get(i).moveOrStop(randomNumbers.get(i));
    }
  }

  public List<Integer> getPositions() {
    return values.stream()
        .map(Car::getPosition)
        .collect(Collectors.toList());
  }

  public int size() {
    return values.size();
  }

  public static Cars makeCars(int count) {
    List<Car> cars = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      cars.add(new Car());
    }
    return new Cars(cars);
  }
}
