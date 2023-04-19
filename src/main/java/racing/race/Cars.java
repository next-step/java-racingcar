package racing.race;

import java.util.LinkedList;
import java.util.List;
import racing.strategy.RandomNumberStrategy;
import racing.view.OutputView;

public class Cars {

  private final List<Car> cars = new LinkedList<>();
  private final List<Car> winnerCars = new LinkedList<>();

  public Cars(String carsName) {
    String[] names = getStrings(carsName);
    ready(names.length, names);
  }

  public void race(int tryNumber) {
    if (tryNumber < 0) {
      throw new NumberFormatException();
    }
    for (int i = 0; i < tryNumber; i++) {
      tryMove();
      OutputView.prinln();
    }
    findWinner();
  }

  public List<Car> getGameCars() {
    return this.cars;
  }

  public List<Car> getWinnerCars() {
    return this.winnerCars;
  }

  private void findWinner() {
    findWinner(findMaxDistance());
  }

  private void findWinner(int maxDistance) {
    for (Car car : this.cars) {
      checkWinner(maxDistance, car);
    }
  }

  private void checkWinner(int maxDistance, Car car) {
    if (car.moveDistance() == maxDistance) {
      winnerCars.add(car);
    }
  }

  private int findMaxDistance() {
    int maxDistance = 0;
    for (Car car : this.cars) {
      maxDistance = Math.max(car.moveDistance(), maxDistance);
    }
    return maxDistance;
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

  private void tryMove() {
    RandomNumberStrategy randomNumberStrategy = new RandomNumberStrategy();
    for (Car car : this.cars) {
      car.move(randomNumberStrategy);
      OutputView.moveDistance(car.name(), car.moveDistance());
    }
  }

}
