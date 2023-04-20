package study.domain.racingGame;

import java.util.HashMap;
import java.util.Map;

public class GameBoard {

  private Map<String, Integer> raceResult;

  public GameBoard(Cars cars) {
    this.raceResult = new HashMap<>();
    registerBoard(cars);
  }

  private GameBoard(Map<String, Integer> raceResult) {
    this.raceResult = new HashMap<>(raceResult);
  }

  private void registerBoard(Cars cars) {
    for (Car car : cars) {
      this.raceResult.put(car.getCarName(), 0);
    }
  }

  public void updateResult(Cars cars) {
    for (Car car : cars) {
      addCarRecord(car);
    }
  }

  private void addCarRecord(Car car) {
    if (!isExistsCar(car.getCarName())) {
      return;
    }
    this.raceResult.put(car.getCarName(), car.getTotalDistance());
  }

  public GameBoard clone() {
    return new GameBoard(this.raceResult);
  }

  private boolean isExistsCar(String carName) {
    return this.raceResult.containsKey(carName);
  }

  public int getResult(String carName) {
    if (!isExistsCar(carName)) {
      throw new RuntimeException("해당 자동차가 존재하지 않습니다.");
    }
    return this.raceResult.get(carName);
  }
}
