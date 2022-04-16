package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

  private final List<Car> values;

  public Cars(List<Car> cars) {
    this.values = cars;
  }

  public static Cars createCars(int count) {
    validateCount(count);
    List<Car> cars = new ArrayList<>();
    for (int i = 0; i < count; i++) {
      cars.add(new Car());
    }
    return new Cars(cars);
  }

  public void move(MovingStrategy movingStrategy) {
    values.forEach(car -> car.moveOrStop(movingStrategy));
  }

  public List<Integer> collectPositions() {
    return values.stream()
        .map(Car::getCurrentPosition)
        .collect(Collectors.toList());
  }

  public int size() {
    return values.size();
  }

  private static void validateCount(int count) {
    if (count < 0) {
      throw new RuntimeException("음수는 입력할 수 없습니다.");
    }
  }
}
