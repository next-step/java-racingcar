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

  public void moveCars(int round) {
    for (int i = 0; i < round; i++) {
      cars.moveAll();
    }
  }

  public String getCarsStatus() {
    return cars.getStatus();
  }

  public void start(int size, int round) {
    initialize(size);
    moveCars(round);
  }
}
