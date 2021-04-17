package study.step3.domain;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

  private CarFactory() {}

  public static Cars makeCar(int carNumber) {
    List<Car> carList = new ArrayList<>();

    MovableStrategy movableStrategy = new CarMovableStrategy();

    for (int i = 0; i < carNumber; i++) {
      Car newCar = new Car(movableStrategy);

      carList.add(newCar);
    }

    return new Cars(carList);
  }

}
