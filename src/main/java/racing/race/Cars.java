package racing.race;

import java.util.LinkedList;
import java.util.List;
import racing.strategy.RandomNumberStrategy;
import racing.view.OutputView;

public class Cars {

  private List<Car> cars = new LinkedList<>();

  public Cars(String carsName) {
    String[] names = getStrings(carsName);
    ready(names.length, names);
  }

  public Cars(List<Car> cars) {
    this.cars = cars;
  }

  public List<Car> race(int tryNumber) {
    if (tryNumber < 0) {
      throw new NumberFormatException();
    }
    for (int i = 0; i < tryNumber; i++) {
      tryMove();
      OutputView.prinln();
    }

    Winner winner = new Winner();
    return winner.findWinner(findMaxDistance(), this);
  }

  int findMaxDistance() {
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

    RandomNumberStrategy randomNumberStrategy = new RandomNumberStrategy();
    for (int i = 0; i < carsNumber; i++) {
      cars.add(new Car(names[i], randomNumberStrategy));
    }
  }

  private void tryMove() {
    for (Car car : this.cars) {
      car.move();
      OutputView.moveDistance(car.name(), car.moveDistance());
    }
  }

  public List<Car> getGameCars() {
    return this.cars;
  }

}
