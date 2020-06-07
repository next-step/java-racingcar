package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.util.RandomMovingStrategy;

public class Cars {

  private final List<Car> carList;

  protected Cars(List<Car> carList) {
    this.carList = carList;
  }

  public List<Car> getCarList() {
    return carList;
  }

  public Cars move() {
    carList.forEach(car -> {
      RandomMovingStrategy strategy = RandomMovingStrategy.create();
      car.updatePosition(strategy);
    });
    return this;
  }

  public static Cars create(String[] names) {
    List<Car> cars = new ArrayList<>();
    for (String name : names) {
      cars.add(Car.create(name));
    }
    return new Cars(cars);
  }
}
