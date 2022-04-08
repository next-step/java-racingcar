package racingCar;

import java.util.ArrayList;
import java.util.List;

public class Track {

  private final List<Car> cars = new ArrayList<>();
  private int gameCount;

  public void addCar(int carCount) {
    for (int i = 0; i < carCount; i++) {
      cars.add(new Car());
    }
  }

  public void setGameCount(int gameCount) {
    this.gameCount = gameCount;
  }

  public List<Car> getCars() {
    return cars;
  }

  public int getGameCount() {
    return gameCount;
  }
}
