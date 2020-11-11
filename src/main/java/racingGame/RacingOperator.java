package racingGame;

import java.util.List;
import java.util.Vector;
import javafx.util.Pair;

public class RacingOperator {

  /**
   * Car에게 position 변경을 지시하는 역할.
   */
  private final Cars cars;
  private int currentRound;

  private RacingOperator(Cars cars) {
    this.cars = cars;
    this.currentRound = 1;
  }

  public static RacingOperator of(Cars cars) {
    return new RacingOperator(cars);
  }

  public void moves(ScoreGenerator scoreGenerator) {
    for (int i = 0; i < cars.getNumCars(); i++) {
      cars.get(i).move(scoreGenerator.generateScore());
    }
    this.currentRound += 1;
  }

  public List<String> extractWinners() {
    return this.cars.extractWinners(this.cars.extractFurthestPosition());
  }

  public List<Pair<String, Integer>> getCarsStatus() {
    return this.cars.getCarsStatus();
  }

  public boolean finished(int numRound) {
    return currentRound > numRound;
  }
}
