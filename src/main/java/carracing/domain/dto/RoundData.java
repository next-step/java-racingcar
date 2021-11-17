package carracing.domain.dto;

import java.util.ArrayList;
import java.util.List;

public class RoundData {

  private final List<RacingData> racingDataList;

  public RoundData(List<RacingData> racingDataList) {
    this.racingDataList = racingDataList;
  }

  public List<RacingData> getRacingDataList() {
    return new ArrayList<>(racingDataList);
  }

}
