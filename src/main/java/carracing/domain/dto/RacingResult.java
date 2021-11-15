package carracing.domain.dto;

import carracing.domain.entity.Winner;

public class RacingResult {

  public final RoundResult result;
  public final Winner winner;

  public RacingResult(RoundResult result, Winner winner) {
    this.result = result;
    this.winner = winner;
  }

  public RoundResult getResult() {
    return new RoundResult(result.getRoundDataList());
  }

  public Winner getWinner() {
    return winner;
  }
}
