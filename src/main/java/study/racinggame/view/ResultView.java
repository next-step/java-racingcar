package study.racinggame.view;

import study.racinggame.domain.Car;
import study.racinggame.domain.Cars;
import study.racinggame.domain.RacingGameStrategy;

import java.util.ArrayList;
import java.util.List;

public class ResultView {

  private final Cars cars;
  private final int tryNumber;
  private static final String PRINTED_DISTANCE = "-";

  public ResultView(int carNumber, int tryNumber) {
    this.cars = initialCars(carNumber);
    this.tryNumber = tryNumber;
  }

  public void play() {
    System.out.println();
    System.out.println("실행 결과");

    for (int i = 0; i < tryNumber; i++) {
      forwardCars(cars.unmodifiableCars());

      System.out.println();
    }
  }

  private void forwardCars(List<Car> cars) {
    for (Car car : cars) {
      car.forward(new RacingGameStrategy());
      printCarDistance(car);
    }
  }

  private void printCarDistance(Car car) {
    System.out.println(PRINTED_DISTANCE.repeat(car.distance()));
  }

  private static Cars initialCars(int carNumber) {
    List<Car> cars = new ArrayList<>();

    for (int i = 0; i < carNumber; i++) {
      cars.add(new Car());
    }

    return new Cars(cars);
  }
}
