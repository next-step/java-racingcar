package carracing.domain.dto;

import carracing.domain.entity.Winner;

import java.util.List;

public class RacingResult {

  public final List<RoundResult> results;
  public final Winner winner;

  public RacingResult(List<RoundResult> results, Winner winner) {
    this.results = results;
    this.winner = winner;
  }

  public List<RoundResult> getResults() {
    return results;
  }

  public Winner getWinner() {
    return winner;
  }
}
