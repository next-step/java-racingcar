package racing.core;

import racing.domain.RacingCars;
import racing.domain.RacingRound;
import racing.rule.MoveRule;
import racing.vo.RacingCarGamePlayInfo;

import java.util.ArrayList;
import java.util.List;


public class RacingCarGame {
  private final MoveRule moveRule;

  public RacingCarGame(MoveRule moveRule) {
    this.moveRule = moveRule;
  }

  public static RacingCarGame newGame(MoveRule moveRule) {
    return new RacingCarGame(moveRule);
  }

  public List<RacingRound> play(RacingCarGamePlayInfo info) {
    int roundTotalCount = info.getRoundTotalCount();
    RacingCars racingCars = info.getPlayers();

    List<RacingRound> racingRounds = new ArrayList<>(roundTotalCount);

    while (roundTotalCount > 0) {
      racingCars.race(moveRule);
      racingRounds.add(RacingRound.create(racingCars, --roundTotalCount));
    }
    return racingRounds;
  }
}
