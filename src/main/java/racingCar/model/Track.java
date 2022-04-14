package racingCar.model;

import java.util.ArrayList;
import java.util.List;

public class Track {

  private final List<Car> cars = new ArrayList<>();
  private int gameCount;

  public void addCar(String names) {
    for (int i = 0; i < names.length(); i++) {
      cars.add(new Car(names));
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
