package study.domain.racingGame;

import java.util.HashMap;
import java.util.Map;

public class GameBoard {

  private Map<Integer, Integer> raceResult;

  public GameBoard(Cars cars) {
    this.raceResult = new HashMap<>();
    registerBoard(cars);
  }

  private GameBoard(Map<Integer, Integer> raceResult) {
    this.raceResult = new HashMap<>(raceResult);
  }

  private void registerBoard(Cars cars) {
    for (int carNumber = 0; carNumber < cars.getTotalCarsCount(); carNumber++) {
      this.raceResult.put(carNumber, 0);
    }
  }

  public void updateResult(Cars cars) {
    for (int carNumber = 0; carNumber < cars.getTotalCarsCount(); carNumber++) {
      if (!isExistsCar(carNumber)) {
        continue;
      }
      this.raceResult.put(carNumber, cars.get(carNumber)
          .getTotalDistance());
    }
  }

  public GameBoard clone() {
    return new GameBoard(this.raceResult);
  }

  private boolean isExistsCar(int carNum) {
    return this.raceResult.containsKey(carNum);
  }

  public int getResult(int carIdx) {
    if(!isExistsCar(carIdx)) {
      throw new RuntimeException("해당 자동차가 존재하지 않습니다.");
    }
    return this.raceResult.get(carIdx);
  }
}
