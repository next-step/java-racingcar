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
    for (int i = 0; i < cars.size(); i++) {
      cars.get(i).move(scoreGenerator.generateScore());
    }
    this.currentRound += 1;
  }

  public List<String> extractWinners() {
    List<String> winners = new Vector<>();
    int numCars = this.cars.size();
    int furthestPosition = discoverFurthestPosition();

    return getWinners(winners, numCars, furthestPosition);
  }

  private List<String> getWinners(List<String> winners, int numCars, int furthestPosition) {
    //이름 뽑아내기
    for (int i = 0; i < numCars; i++) {
      insertNames(cars.get(i), furthestPosition, winners);
    }

    return winners;
  }

  private int discoverFurthestPosition() {
    int furthestPosition = cars.get(0).getPosition();

    //가장 멀리간 위치 확인
    for (int i = 0; i < cars.size(); i++) {
      furthestPosition = Math.max(furthestPosition, cars.get(i).getPosition());
    }

    return furthestPosition;
  }

  private void insertNames(Car target, int furthestPosition, List<String> winners) {
    if (target.getPosition() == furthestPosition) {
      winners.add(target.getName());
    }
  }

  public List<Pair<String, Integer>> getCurrentCarsStatus() {
    List<Pair<String, Integer>> status = new Vector<>();

    for (int i = 0; i < this.cars.size(); i++) {
      status.add(new Pair<>(cars.get(i).getName(), cars.get(i).getPosition()));
    }

    return status;
  }

  public boolean finished(int numRound) {
    return currentRound > numRound;
  }
}
