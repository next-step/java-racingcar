package racing.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingRound {

  public static final int LIMIT_RANDOM_NUMBER = 10;

  public static final int MORE_THAN_NUMBER_FOR_CAR_MOVE = 4;

  private List<RacingCar> racingCars;

  public void record(List<RacingCar> racingCars) {
    for (RacingCar car : racingCars) {
      if (isMove()) {
        car.move();
      }

      capture(car);
    }
  }

  public void capture(RacingCar racingCar) {
    getRacingCars().add(RacingCar.copy(racingCar));
  }

  private boolean isMove() {
    return getRandomNumber() >= MORE_THAN_NUMBER_FOR_CAR_MOVE;
  }

  private int getRandomNumber() {
    return new Random().nextInt(LIMIT_RANDOM_NUMBER);
  }

  public List<RacingCar> getRacingCars() {
    if (this.racingCars == null) {
      this.racingCars = new ArrayList<>();
    }
    return this.racingCars;
  }
}
