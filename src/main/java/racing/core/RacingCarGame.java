package racing.core;

import racing.domain.RacingCars;
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

  public List<RacingRound> play() {
    int totalRound = info.getTotalRound();
    RacingCars racingCars = info.getPlayers();

    List<RacingRound> racingRounds = new ArrayList<>(totalRound);

    for (int i = 0; i < totalRound; i++) {
      boolean finalRound = totalRound == i + 1;
      racingCars.race(moveRule);
      racingRounds.add(RacingRound.create(racingCars, finalRound));
    }
    return racingRounds;
  }
}
