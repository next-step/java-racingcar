package study.step3.domain;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

  public static List<Car> makeCar(int carNumber) {
    List<Car> cars = new ArrayList<>();

    for (int i = 0; i < carNumber; i++) {
      cars.add(new Car());
    }

    return cars;
  }

}
