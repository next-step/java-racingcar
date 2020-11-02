package racinggame.model;

import java.util.List;
import java.util.Objects;

public class RacingResult {

  private List<MovingResult> movingResults;

  public RacingResult(List<MovingResult> movingResults) {
    this.movingResults = movingResults;
  }

  public List<MovingResult> getMovingResults() {
    return movingResults;
  }

  public String getWinnerCarNames() {
    return getLastRoundResult().getWinnerCarNames();
  }

  private MovingResult getLastRoundResult() {
    return this.movingResults.get(movingResults.size() - 1);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RacingResult that = (RacingResult) o;
    return Objects.equals(movingResults, that.movingResults);
  }

  @Override
  public int hashCode() {
    return Objects.hash(movingResults);
  }
}
