package racing.vo;

import racing.domain.RacingCar;
import racing.domain.RacingCars;
import racing.utils.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGamePlayInfo {

  private final RacingCars players;
  private final int roundTotalCount;

  private RacingCarGamePlayInfo(RacingCars players, int roundTotalCount) {
    this.players = players;
    this.roundTotalCount = roundTotalCount;
  }

  public static RacingCarGamePlayInfo newPlayInfo(String playerNames, int roundTotalCount) {
    List<RacingCar> players = StringUtils.toList(playerNames).stream()
            .map(StringUtils::trim)
            .map(RacingCar::create)
            .collect(Collectors.toList());

    return new RacingCarGamePlayInfo(RacingCars.create(players), roundTotalCount);
  }

  public RacingCars getPlayers() {
    return players;
  }

  public int getRoundTotalCount() {
    return roundTotalCount;
  }
}
