package racing.race;

import java.util.LinkedList;
import java.util.List;
import racing.strategy.RandomNumberStrategy;
import racing.view.OutputView;

public class Cars {

  private final List<Car> cars = new LinkedList<>();

  public Cars(String carsName) {
    String[] names = getStrings(carsName);
    ready(names.length, names);
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

  public List<Car> getGameCar() {
    return cars;
  }

  private String[] getStrings(String carsName) {
    return carsName.split(",");
  }

  private void ready(int carsNumber, String[] names) {
    if (carsNumber < 0) {
      throw new NumberFormatException();
    }
    for (int i = 0; i < carsNumber; i++) {
      cars.add(new Car(validCarName(names[i])));
    }
  }

  private String validCarName(String name) {
    if (name.length() > 5) {
      throw new StringIndexOutOfBoundsException();
    }
    return name;
  }

  private void tryMove(List<Car> cars) {
    RandomNumberStrategy randomNumberStrategy = new RandomNumberStrategy();
    for (Car car : cars) {
      car.move(randomNumberStrategy);
      OutputView.numberToDash(car.moveDistance());
    }
  }

}
