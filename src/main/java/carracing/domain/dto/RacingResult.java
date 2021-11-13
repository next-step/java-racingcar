package carracing.domain.dto;

import java.util.List;

public class RacingResult {

  public final List<RoundResult> results;

  public RacingResult(List<RoundResult> results) {
    this.results = results;
  }

  public List<RoundResult> getResults() {
    return results;
  }
}
