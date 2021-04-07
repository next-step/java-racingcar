package study.step3;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

  public static List<Car> makeCar(int carNumber) {

    if (carNumber < 0) {
      throw new IllegalArgumentException("0보다 큰 값을 입력해야합니다.");
    }

    List<Car> cars = new ArrayList<>();

    for (int i = 0; i < carNumber; i++) {
      cars.add(new Car());
    }

    return cars;
  }

}
