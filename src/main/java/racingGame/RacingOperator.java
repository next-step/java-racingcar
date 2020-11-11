package racingGame;

import java.util.List;
import javafx.util.Pair;

public class RacingOperator {

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
    cars.movesCar(scoreGenerator);
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
