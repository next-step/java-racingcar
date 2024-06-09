package core.game;

import core.car.Car;
import java.util.List;

public class Game {

  private List<Car> cars;

  Game(List<Car> cars) {
    this.cars = cars;
  }

  public List<Car> getCars() {
    return cars;
  }
}
