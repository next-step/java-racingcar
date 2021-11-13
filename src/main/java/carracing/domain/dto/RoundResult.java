package carracing.domain.dto;

import java.util.List;

public class RoundResult {

  private final List<RacingData> racingDataList;

  public RoundResult(List<RacingData> racingDataList) {
    this.racingDataList = racingDataList;
  }

  public List<RacingData> getRacingDataList() {
    return racingDataList;
  }

  public static RoundResult of (List<RacingData> racingDataList) {
    return new RoundResult(racingDataList);
  }
}
