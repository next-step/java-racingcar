package racing.core;

import racing.domain.RacingCar;
import racing.domain.RacingRound;
import racing.vo.RacingCarGamePlayInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class RacingCarGame {

  public static final int LIMIT_RANDOM_NUMBER = 10;
  public static final int MORE_THAN_NUMBER_FOR_CAR_MOVE = 4;
  private final RacingCarGamePlayInfo info;

  private RacingCarGame(RacingCarGamePlayInfo info) {
    this.info = info;
  }

  public static RacingCarGame newGame(RacingCarGamePlayInfo info) {
    return new RacingCarGame(info);
  }

  public List<RacingRound> play() {
    int totalRound = info.getTotalRound();
    List<RacingCar> racingCars = info.getPlayers();

    List<RacingRound> racingRounds = new ArrayList<>(totalRound);
    for (int i = 0; i < totalRound; i++) {
      for (RacingCar car : racingCars) {
        if (isMove())
          car.move();
      }
      racingRounds.add(RacingRound.createRecord(racingCars));
    }
    return racingRounds;
  }

  private boolean isMove() {
    return getRandomNumber() >= MORE_THAN_NUMBER_FOR_CAR_MOVE;
  }

  private int getRandomNumber() {
    return new Random().nextInt(LIMIT_RANDOM_NUMBER);
  }

}
