package racing.core;

import racing.domain.RacingCar;
import racing.domain.RacingRound;
import racing.rule.MoveRule;
import racing.vo.RacingCarGamePlayInfo;

import java.util.ArrayList;
import java.util.List;


public class RacingCarGame {

  private final RacingCarGamePlayInfo info;
  private MoveRule moveRule;

  private RacingCarGame(RacingCarGamePlayInfo info) {
    this.info = info;
  }

  public static RacingCarGame newGame(RacingCarGamePlayInfo info) {
    return new RacingCarGame(info);
  }

  public RacingCarGame setupRule(MoveRule moveRule) {
    this.moveRule = moveRule;
    return this;
  }

  public List<RacingRound> play() {
    int totalRound = info.getTotalRound();
    List<RacingCar> racingCars = info.getPlayers();

    List<RacingRound> racingRounds = new ArrayList<>(totalRound);
    for (int i = 0; i < totalRound; i++) {
      for (RacingCar car : racingCars) {
        moveOrStop(moveRule, car);
      }
      racingRounds.add(RacingRound.createRecord(racingCars));
    }
    return racingRounds;
  }

  private void moveOrStop(MoveRule moveRule, RacingCar car) {
    if (moveRule.isPossibleMove()) {
      car.move();
    }
  }

}
