package racingcar;

import java.util.List;
import java.util.Random;
import racingcar.io.Printer;

public class Game {

  private final Cars cars;

  public Game(Random random) {
    this.cars = new Cars(random);
  }

  public void initialize(List<String> names) {
    cars.initialize(names);
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

  public String getCarsNameAndStatus() {
    return cars.getNameAndStatus();
  }

  public void start(List<String> names, int round) {
    initialize(names);
    moveCars(round);
  }
}
