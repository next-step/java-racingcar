package racingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingCars {

  private final List<RacingCar> racingCarList;
  int tryCount;

  public RacingCars() {
    this.racingCarList = new ArrayList<>();
    this.tryCount = 0;
  }

  public void add(RacingCar racingCar) {
    racingCarList.add(racingCar);
  }

  public void moveAllCars() {
    racingCarList.forEach(e -> e.tryMove(new Random().nextInt(10)));
    this.tryCount++;
  }

  public int[] getAllCarsMoveCount() {
    return racingCarList.stream().mapToInt(RacingCar::getMoveCount).toArray();
  }
}
