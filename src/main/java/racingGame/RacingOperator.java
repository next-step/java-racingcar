package racingGame;

import java.util.List;
import java.util.Vector;
import javafx.util.Pair;

public class RacingOperator {

  /**
   * Car에게 position 변경을 지시하는 역할.
   */
  private final Cars cars;
  private final ScoreGenerator scoreGenerator;

  private RacingOperator(Cars cars, ScoreGenerator scoreGenerator) {
    this.cars = cars;
    this.scoreGenerator = scoreGenerator;
  }

  public static RacingOperator of(Cars cars, ScoreGenerator scoreGenerator) {
    return new RacingOperator(cars, scoreGenerator);
  }

  public static RacingOperator of(Cars cars) {
    ScoreGenerator scoreGenerator = new RandomScoreGenerator();
    return new RacingOperator(cars, scoreGenerator);
  }

  public void moves() {
    for (int i = 0; i < cars.size(); i++) {
      cars.get(i).move(this.scoreGenerator.generateScore());
    }
  }

  public List<String> extractWinners() {
    List<String> winners = new Vector<>();
    int numCars = this.cars.size();
    int furthestPosition = cars.get(0).getPosition();

    //가장 멀리간 위치 확인
    for (int i = 0; i < numCars; i++) {
      if (cars.get(i).getPosition() > furthestPosition) {
        furthestPosition = cars.get(i).getPosition();
      }
    }

    //이름 뽑아내기
    for (int i = 0; i < numCars; i++) {
      if (cars.get(i).getPosition() == furthestPosition) {
        winners.add(cars.get(i).getName());
      }
    }

    return winners;
  }

  // 게임에 사용되는 Car 전체의 position을 반환하는 기능
  public List<Integer> getPositions() {
    List<Integer> positions = new Vector<>(cars.size());

    for (int i = 0; i < cars.size(); i++) {
      positions.add(i, cars.get(i).getPosition());
    }

    return positions;
  }

  public List<Pair<String, Integer>> getCurrentCarsStatus() {
    List<Pair<String, Integer>> status = new Vector<>();

    for (int i = 0; i < this.cars.size(); i++) {
      String name = cars.get(i).getName();
      int position = cars.get(i).getPosition();

      Pair<String, Integer> pair = new Pair<>(name, position);
      status.add(pair);
    }

    return status;
  }
}
