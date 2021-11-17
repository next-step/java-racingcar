package carracing.domain.dto;

import carracing.domain.entity.Challengers;

public class RacingResult {

  public final RoundResult result;
  public final Challengers winner;

  public RacingResult(RoundResult result, Challengers winner) {
    this.result = result;
    this.winner = winner;
  }

  public RoundResult getResult() {
    return new RoundResult(result.getRoundDataList());
  }

  public Challengers getWinner() {
    return winner;
  }
}
