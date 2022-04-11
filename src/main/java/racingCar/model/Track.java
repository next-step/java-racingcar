package racingCar.model;

import java.util.ArrayList;
import java.util.List;

public class Track {

  private final List<Car> cars = new ArrayList<>();
  private int gameCount;

  public void addCar(String names) {
    String[] splitNames = splitNames(names);
    for (String name : splitNames) {
      cars.add(new Car(name));
    }
  }

  private String[] splitNames(String names) {
    return names.split(",");
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
