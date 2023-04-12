package racingCar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingCar.car.RacingCar;

public class RacingCarGame {

  private final List<RacingCar> racingCarList;
  private final long moveTryCnt;

  public RacingCarGame(long carCnt, long moveTryCnt) {
    this.racingCarList = generateRacingCars(carCnt);
    this.moveTryCnt = moveTryCnt;
  }

  private List<RacingCar> generateRacingCars(long carCnt) {
    List<RacingCar> carList = new ArrayList<>((int) carCnt);
    for (long i = 1; i <= carCnt; i++) {
      carList.add(new RacingCar(i));
    }
    return Collections.unmodifiableList(carList);
  }

  public void play () {

  }
}
