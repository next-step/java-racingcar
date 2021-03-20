package racing.vo;

import racing.domain.RacingCar;
import racing.domain.RacingCars;
import racing.utils.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGamePlayInfo {

  private final RacingCars players;
  private final int totalRound;

  private RacingCarGamePlayInfo(RacingCars players, int totalRound) {
    this.players = players;
    this.totalRound = totalRound;
  }

  public static RacingCarGamePlayInfo newPlayInfo(String playerNames, int totalRound) {
    List<RacingCar> players = StringUtils.toList(playerNames).stream()
            .map(RacingCar::create)
            .collect(Collectors.toList());

    return new RacingCarGamePlayInfo(RacingCars.create(players), totalRound);
  }

  public RacingCars getPlayers() {
    return players;
  }

  public int getTotalRound() {
    return totalRound;
  }
}
