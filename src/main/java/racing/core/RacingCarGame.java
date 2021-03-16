package racing.core;

import racing.domain.RacingCar;
import racing.domain.RacingRound;
import racing.vo.RacingCarGamePlayInfo;

import java.util.ArrayList;
import java.util.List;


public class RacingCarGame {

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
    List<RacingRound> result = new ArrayList<>(totalRound);
    for (int i = 0; i < totalRound; i++) {
      RacingRound round = new RacingRound();
      round.record(racingCars);
      result.add(round);
    }
    return result;
  }

}
