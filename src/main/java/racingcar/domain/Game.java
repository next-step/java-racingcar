package racingcar.domain;

import java.util.List;
import java.util.Random;
import racingcar.view.Printer;

public class Game {

  private final Cars cars;
  private Winner winner;

  public Game(Random random) {
    this.cars = new Cars(random);
  }

  public void initialize(List<Car> cars) {
    this.cars.initialize(cars);
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

  public void start(List<Car> cars, int round) {
    initialize(cars);
    moveCars(round);
    selectWinner();
  }

  private void selectWinner() {
    this.winner = cars.getWinner();
  }

  public List<CarName> getWinners() {
    return winner.getWinners();
  }

  public String getWinnerListString() {
    return winner.winnerListString();
  }
}
