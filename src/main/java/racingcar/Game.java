package racingcar;

import java.util.Random;

public class Game {

  private final Cars cars;

  public Game(Random random) {
    this.cars = new Cars(random);
  }

  public void initialize(int size) {
    cars.initialize(size);
  }

  public int getCarCount() {
    return cars.getCarCount();
  }

  public void moveCars(int rounds) {
    for (int i = 0; i < rounds; i++) {
      cars.moveAll();
    }
  }

  public String getCarsStatus() {
    return cars.getStatus();
  }
}
