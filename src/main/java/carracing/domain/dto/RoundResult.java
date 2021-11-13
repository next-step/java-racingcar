package carracing.domain.dto;

import java.util.List;

public class RoundResult {

  private List<RacingData> racingDataList;

  public RoundResult(List<RacingData> racingDataList) {
    this.racingDataList = racingDataList;
  }

  public List<RacingData> getRacingDataList() {
    return racingDataList;
  }
}
