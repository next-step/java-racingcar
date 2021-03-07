package racingcar;

import java.util.Random;
import racingcar.io.Printer;

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
      Printer.printGameResult(this);
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
