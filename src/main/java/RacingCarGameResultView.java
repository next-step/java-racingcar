import java.util.List;

public class RacingCarGameResultView {

  public static final String PROGRESS_SYMBOL = "-";

  private RacingCarGame racingCarGame;

  public RacingCarGameResultView(RacingCarGame racingCarGame) {
    this.racingCarGame = racingCarGame;
  }

  public void showResult() {
    List<List<Integer>> resultList = racingCarGame.getResults().getResultList();
    resultList.forEach(result -> {
      showProgress(result);
      System.out.println();
    });
  }

  private void showProgress(List<Integer> result) {
    result.forEach(progress -> {
      String progressExpression = "";
      for (int i = 0; i < progress; i++) {
        progressExpression += PROGRESS_SYMBOL;
      }
      System.out.println(progressExpression);
    });
  }

}
