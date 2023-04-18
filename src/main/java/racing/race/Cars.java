package racing.race;

import java.util.LinkedList;
import java.util.List;
import racing.strategy.RandomNumberStrategy;
import racing.view.OutputView;

public class Cars {

  private final List<Car> cars = new LinkedList<>();

  public Cars(int carsNumber) {
    ready(carsNumber);
  }

  private void ready(int carsNumber) {
    if (carsNumber < 0) {
      throw new NumberFormatException();
    }
    for (int i = 0; i < carsNumber; i++) {
      cars.add(new Car());
    }
  }

  public List<Car> getGameCar() {
    return cars;
  }

  public void race(List<Car> cars, int tryNumber) {
    if (tryNumber < 0) {
      throw new NumberFormatException();
    }
    for (int i = 0; i < tryNumber; i++) {
      tryMove(cars);
      System.out.println();
    }
  }

  private void tryMove(List<Car> cars) {
    RandomNumberStrategy randomNumberStrategy = new RandomNumberStrategy();
    for (Car car : cars) {
      car.move(randomNumberStrategy);
      OutputView.printNumberToDash(car.moveDistance());
    }
  }

}
