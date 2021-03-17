package racing.core;

import racing.domain.RacingCar;
import racing.domain.RacingRound;
import racing.rule.MoveRule;
import racing.vo.RacingCarGamePlayInfo;

import java.util.ArrayList;
import java.util.List;


public class RacingCarGame {

  private final RacingCarGamePlayInfo info;
  private final MoveRule moveRule;

  public RacingCarGame(RacingCarGamePlayInfo info, MoveRule moveRule) {
    this.info = info;
    this.moveRule = moveRule;
  }

  public static RacingCarGame newGame(RacingCarGamePlayInfo info, MoveRule moveRule) {
    return new RacingCarGame(info, moveRule);
  }

  public List<RacingRound> endGame() {
    int totalRound = info.getTotalRound();
    List<RacingCar> racingCars = info.getPlayers();

    List<RacingRound> racingRounds = new ArrayList<>(totalRound);
    for (int i = 0; i < totalRound; i++) {
      for (RacingCar car : racingCars) {
        car.move(moveRule);
      }
      racingRounds.add(RacingRound.newRecord(racingCars));
    }
    return racingRounds;
  }
}
