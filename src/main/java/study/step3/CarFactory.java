package study.step3;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

  private static final int CAR_NUMBER_CHECK = 0;

  public static List<Car> makeCar(int carNumber) {

    if (carNumber == CAR_NUMBER_CHECK) {
      throw new IllegalArgumentException("0보다 큰 값을 입력해야합니다.");
    }

    List<Car> cars = new ArrayList<>();

    for (int i = 0; i < carNumber; i++) {
      cars.add(new Car());
    }

    return cars;
  }

}
