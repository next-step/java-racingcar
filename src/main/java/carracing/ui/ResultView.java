package carracing.ui;

import carracing.domain.dto.RacingData;
import carracing.domain.dto.RacingResult;
import carracing.domain.dto.RoundResult;
import carracing.domain.entity.Car;

import static java.util.stream.Collectors.joining;

public class ResultView {

  private static ResultView instance;

  private static final String STEP_STRING = "-";
  private static final String BLANK_STRING = " ";
  private static final String COLON = ":";
  private static final String COMMA = ",";
  private static final String WINNER_MESSAGE = "가 우승 했습니다.";
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
    printWinner(racingResult);
    System.out.println(sb);
  }

  private void combineRoundResult(RoundResult result) {
    result.getRacingDataList().forEach(racingData -> {
      convertCarStatusToString(racingData);
      sb.append(System.lineSeparator());
    });
  }

  private void convertCarStatusToString(RacingData racingData) {
    sb.append(racingData.getName()).append(BLANK_STRING).append(COLON).append(BLANK_STRING);
    for (int i = 0; i < racingData.getStep(); i++) {
      sb.append(STEP_STRING);
    }
  }

  private void printWinner(RacingResult racingResult) {
    sb.append(racingResult.getWinner().getWinnerList()
                                      .stream()
                                      .map(Car::getName)
                                      .collect(joining(COMMA)));
    sb.append(WINNER_MESSAGE);
  }
}
