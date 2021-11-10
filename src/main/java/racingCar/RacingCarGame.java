package racingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCarGame {

  private final List<RacingCar> racingCarList = new ArrayList<>();
  private final int TRY_COUNT;

  public RacingCarGame(int carCount, int tryCount) {
    createCars(carCount);
    this.TRY_COUNT = tryCount;
  }

  private void createCars(int carCount) {
    for (int i = 0; i < carCount; i++) {
      racingCarList.add(new RacingCar());
    }
  }

  public void start() {
    for (int currentMoveCount = 0; currentMoveCount < TRY_COUNT; currentMoveCount++) {
      tryMove();
    }
  }

  private void tryMove() {
    if (!canMove()) {
      return;
    }
    racingCarList.forEach(RacingCar::move);
  }

  private boolean canMove() {
    return new Random().nextInt(10) >= 4;
  }
}
