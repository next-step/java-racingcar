package racing.vo;

import racing.domain.RacingCar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCarGamePlayInfo {

  private final List<RacingCar> players;
  private final int totalRound;

  private RacingCarGamePlayInfo(int totalPlayer, int totalRound) {
    this.players = IntStream.range(0, totalPlayer)
            .mapToObj(RacingCar::createNew)
            .collect(Collectors.toList());
    ;
    this.totalRound = totalRound;
  }

  public static RacingCarGamePlayInfo newPlayInfo(int totalPlayer, int totalRound) {
    return new RacingCarGamePlayInfo(totalPlayer, totalRound);
  }

  public List<RacingCar> getPlayers() {
    return players;
  }

  public int getTotalRound() {
    return totalRound;
  }
}
