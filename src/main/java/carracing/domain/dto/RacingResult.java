package carracing.domain.dto;

import carracing.domain.entity.Cars;

public class RacingResult {

  public final RoundResult result;
  public final Cars winner;

  public RacingResult(RoundResult result, Cars winner) {
    this.result = result;
    this.winner = winner;
  }

  public RoundResult getResult() {
    return new RoundResult(result.getRoundDataList());
  }

  public Cars getWinner() {
    return winner;
  }
}
