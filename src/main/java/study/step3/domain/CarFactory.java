package study.step3.domain;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

  private CarFactory() {}

  public static Cars makeCars(String[] names) {
    List<Car> carList = new ArrayList<>();

    MovableStrategy movableStrategy = new CarMovableStrategy();

    for (String name : names) {
      Car newCar = new Car(movableStrategy, name);
      carList.add(newCar);
    }

    return new Cars(carList);
  }

}
