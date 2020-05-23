package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

  protected Cars(List<Car> cars) {
    this.cars = cars;
  }

  private final List<Car> cars;

  public List<Car> getCars() {
    return cars;
  }

  public static Cars create(String[] names) {
    List<Car> cars = new ArrayList<>();
    for (String name : names) {
      cars.add(Car.create(name));
    }
    return new Cars(cars);
  }
}
