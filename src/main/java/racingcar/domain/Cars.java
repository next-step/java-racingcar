package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Cars {

  protected Cars(List<Car> carList) {
    this.carList = carList;
  }

  private final List<Car> carList;

  public List<Car> getCarList() {
    return carList;
  }

  public static Cars create(String[] names) {
    List<Car> cars = new ArrayList<>();
    for (String name : names) {
      cars.add(Car.create(name));
    }
    return new Cars(cars);
  }
}
