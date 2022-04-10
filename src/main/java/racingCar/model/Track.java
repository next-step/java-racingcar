package racingCar.model;

import java.util.ArrayList;
import java.util.List;
import racingCar.model.Car;

public class Track {

  private final List<Car> cars = new ArrayList<>();
  private int gameCount;

  public void addCar(int carCount) {
    for (int i = 0; i < carCount; i++) {
      cars.add(new Car());
    }
  }

  public List<Car> getCars() {
    return cars;
  }

  public int getGameCount() {
    return gameCount;
  }

  public void setGameCount(int gameCount) {
    this.gameCount = gameCount;
  }

}
