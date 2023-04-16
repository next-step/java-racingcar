package racingcar.domain;

import racingcar.repository.NormalMoveStrategy;
import racingcar.repository.MoveStrategy;

public class Racing {
  private RacingCars racing;

  public Racing(RacingCars racingCars) {
    this.racing = racingCars;
  }

  // racing 진행
  public void startRacingRound() {
    for (RacingCar racingCar : this.racing.statusOfRacingCars()) {
      racingCar.tryToMove(defaultRacingMoveStrategy());
    }
  }

  // move 전략패턴
  public static MoveStrategy defaultRacingMoveStrategy() {
    return new NormalMoveStrategy();
  }

  public RacingCar[] statusOfRacing() {
    return this.racing.statusOfRacingCars();
  }
}