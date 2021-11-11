import java.util.List;
import java.util.Map;

public class RacingCarGameResultView {

  public static final String PROGRESS_SYMBOL = "-";
  public static final String DELIMITER = Constants.STRING_DELIMITER + " ";

  private RacingCarGame racingCarGame;

  public RacingCarGameResultView(RacingCarGame racingCarGame) {
    this.racingCarGame = racingCarGame;
  }

  public void showResult() {
    Map<Integer, List<RacingCarResult>> results = racingCarGame.getResults().getResults();
    results.forEach((round, result) -> {
      showProgress(result);
      System.out.println();
    });
    showWinnerNames(racingCarGame.getResults());
  }

  private void showWinnerNames(RacingCarGameResults racingCarGameResults) {
    List<String> winnerNames = racingCarGameResults.getWinnerNames();
    String joinedWinnerNames = Strings.join(winnerNames, DELIMITER);
    System.out.printf("%s가 최종 우승했습니다.%n", joinedWinnerNames);
  }

  private void showProgress(List<RacingCarResult> roundResults) {
    roundResults.forEach(result -> {
      System.out.print(String.format("%s : ", result.getName()));
      String progressExpression = getProgressExpression(result.getProgress());
      System.out.println(progressExpression);
    });
  }

  private String getProgressExpression(int progress) {
    String progressExpression = "";
    for (int i = 0; i < progress; i++) {
      progressExpression += PROGRESS_SYMBOL;
    }
    return progressExpression;
  }

}
