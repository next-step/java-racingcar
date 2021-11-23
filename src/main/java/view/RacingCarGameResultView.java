package view;

import common.Constants;
import common.Strings;
import domain.RacingCarGameResults;
import domain.RacingCarResult;

import java.util.List;
import java.util.Map;

public class RacingCarGameResultView {

  public static final String PROGRESS_SYMBOL = "-";
  public static final String DELIMITER = Constants.STRING_DELIMITER + " ";

  private RacingCarGameResults racingCarGameResults;

  public RacingCarGameResultView(RacingCarGameResults racingCarGameResults) {
    this.racingCarGameResults = racingCarGameResults;
  }

  public void showResult() {
    Map<Integer, List<RacingCarResult>> results = racingCarGameResults.getResults();
    results.forEach((round, result) -> {
      showProgress(result);
      System.out.println();
    });
    showWinnerNames(racingCarGameResults);
  }

  private void showWinnerNames(RacingCarGameResults racingCarGameResults) {
    List<String> winnerNames = racingCarGameResults.getWinnerNames();
    String joinedWinnerNames = Strings.join(winnerNames, DELIMITER);
    System.out.printf("%s가 최종 우승했습니다.%n", joinedWinnerNames);
  }

  private void showProgress(List<RacingCarResult> roundResults) {
    roundResults.forEach(result -> {
      System.out.printf("%s : ", result.getName());
      String progressExpression = makeProgressExpression(result.getProgress());
      System.out.println(progressExpression);
    });
  }

  private String makeProgressExpression(int progress) {
    String progressExpression = "";
    for (int i = 0; i < progress; i++) {
      progressExpression += PROGRESS_SYMBOL;
    }
    return progressExpression;
  }

}
