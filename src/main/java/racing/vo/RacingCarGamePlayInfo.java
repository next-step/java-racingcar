package racing.vo;

import racing.domain.RacingCars;

public class RacingCarGamePlayInfo {

  private final RacingCars players;
  private final int totalRound;

  private RacingCarGamePlayInfo(int totalPlayer, int totalRound) {
    this.players = RacingCars.create(totalPlayer);
    this.totalRound = totalRound;
  }

  public static RacingCarGamePlayInfo newPlayInfo(int totalPlayer, int totalRound) {
    return new RacingCarGamePlayInfo(totalPlayer, totalRound);
  }

  public RacingCars getPlayers() {
    return players;
  }

  public int getTotalRound() {
    return totalRound;
  }
}
