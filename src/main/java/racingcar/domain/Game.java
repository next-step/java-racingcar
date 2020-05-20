package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.util.RandomUtil;

public class Game {

  private List<Car> cars;
  private int raceNum;

  private Game(List<Car> cars) {
    this.cars = new ArrayList<>(cars);
  }

  public List<Car> doRace() {
    this.cars.forEach(element -> {
      int random = RandomUtil.getRandomValue();
      element.updatePosition(random);
    });
    raceNum++;
    return this.cars;
  }

  public List<Car> getCars() {
    return cars;
  }

  public Integer getRaceNum() {
    return raceNum;
  }

  public static Game create(List<Car> cars) {
    return new Game(cars);
  }
}
