package carracing.ui;

import carracing.domain.dto.RacingData;
import carracing.domain.dto.RacingResult;
import carracing.domain.dto.RoundResult;

public class ResultView {

  private static ResultView instance;

  private static final String STEP_STRING = "-";
  private StringBuilder sb;

  private ResultView() {}

  public static ResultView getInstance() {
    if (instance == null) {
      return new ResultView();
    }
    return instance;
  }

  public void printResult(RacingResult racingResult) {
    sb = new StringBuilder();
    for (RoundResult result : racingResult.getResults()) {
      combineRoundResult(result);
      sb.append(System.lineSeparator());
    }
    System.out.println(sb);
  }

  private void combineRoundResult(RoundResult result) {
    for (RacingData racingData : result.getRacingDataList()) {
      convertCarStatusToString(racingData);
      sb.append(System.lineSeparator());
    }
  }

  private void convertCarStatusToString(RacingData racingData) {
    for (int i = 0; i < racingData.getStep(); i++) {
      sb.append(STEP_STRING);
    }
  }


}
