package racingCar.model;

import java.util.ArrayList;
import java.util.List;
import racingCar.util.StringUtils;

public class Track {

  private static final String CAR_DELIMITER = ",";
  private final List<Car> cars = new ArrayList<>();
  private int gameCount;

  public void addCar(String names) {
    String[] carNames = readyCarNames(names);
    for (String carName : carNames) {
      cars.add(new Car(carName));
    }
  }

  private String[] readyCarNames(String names) {
    return StringUtils.split(names, CAR_DELIMITER);
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
