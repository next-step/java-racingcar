package racingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RacingCarGame {
  private final List<RacingCar> racingCarList = new ArrayList<>();
  private final int MOVE_COUNT;

  public RacingCarGame(int carCount, int moveCount) {
    createCars(carCount);
    this.MOVE_COUNT = moveCount;
  }

  private void createCars(int carCount) {
    for (int i = 0; i < carCount; i++) {
      racingCarList.add(new RacingCar());
    }
  }
}
