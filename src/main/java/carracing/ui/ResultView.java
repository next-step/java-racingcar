package carracing.ui;

import carracing.domain.dto.RacingData;
import carracing.domain.dto.RacingResult;
import carracing.domain.dto.RoundData;
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
  private StringBuilder stringBuilder;

  private ResultView() {}

  public static ResultView getInstance() {
    if (instance == null) {
      return instance = new ResultView();
    }
    return instance;
  }

  public void printResult(RacingResult racingResult) {
    stringBuilder = new StringBuilder();
    composeResult(racingResult);
    System.out.println(stringBuilder);
  }

  private void composeResult(RacingResult racingResult) {
    RoundResult roundResult = racingResult.getResult();
    appendRacingData(roundResult);
    appendRacingWinner(racingResult);
  }

  private void appendRacingData(RoundResult roundResult) {
    for (RoundData result : roundResult.getRoundDataList()) {
      combineRoundResult(result);
      stringBuilder.append(System.lineSeparator());
    }
  }

  private void combineRoundResult(RoundData result) {
    result.getRacingDataList().forEach(racingData -> {
      convertCarStatusToString(racingData);
      stringBuilder.append(System.lineSeparator());
    });
  }

  private void convertCarStatusToString(RacingData racingData) {
    stringBuilder.append(racingData.getName())
                 .append(BLANK_STRING)
                 .append(COLON)
                 .append(BLANK_STRING);
    for (int i = 0; i < racingData.getStep(); i++) {
      stringBuilder.append(STEP_STRING);
    }
  }

  private void appendRacingWinner(RacingResult racingResult) {
    stringBuilder.append(racingResult.getWinner().getChallengers()
                                      .stream()
                                      .map(Car::getName)
                                      .collect(joining(COMMA)));
    stringBuilder.append(WINNER_MESSAGE);
  }
}
