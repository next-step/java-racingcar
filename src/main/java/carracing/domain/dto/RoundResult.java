package carracing.domain.dto;

import java.util.ArrayList;
import java.util.List;

public class RoundResult {

  private final List<RoundData> roundDataList;

  public RoundResult(List<RoundData> roundDataList) {
    this.roundDataList = roundDataList;
  }

  public List<RoundData> getRoundDataList() {
    return new ArrayList<>(roundDataList);
  }
}
