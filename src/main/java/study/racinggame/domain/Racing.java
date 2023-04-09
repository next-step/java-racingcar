package study.racinggame.domain;

import java.util.ArrayList;
import java.util.List;

public class Racing {
  private final Cars cars;
  private final int tryNumber;

  public Racing(int carNumber, int tryNumber) {
    this.cars = initialCars(carNumber);
    this.tryNumber = tryNumber;
  }

  public void play() {
    System.out.println();
    System.out.println("실행 결과");

    for (int i = 0; i < tryNumber; i++) {
      cars.forwardCars();

      System.out.println();
    }
  }

  private static Cars initialCars(int carNumber) {
    List<Car> cars = new ArrayList<>();

    for (int i = 0; i < carNumber; i++) {
      cars.add(new Car());
    }

    return new Cars(cars);
  }
}
