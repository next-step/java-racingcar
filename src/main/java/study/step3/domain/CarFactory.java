package study.step3.domain;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

  public static Cars makeCar(int carNumber) {
    List<Car> carList = new ArrayList<>();

    for (int i = 0; i < carNumber; i++) {
      carList.add(new Car());
    }

    return new Cars(carList);
  }

}
