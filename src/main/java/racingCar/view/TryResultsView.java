package racingCar.view;

import java.util.List;
import racingCar.domain.TryResult;

public class TryResultsView {

  private static final String COLON = " : ";
  private static final String HYPHEN = "-";

  private List<TryResult> tryResults;

  public TryResultsView(List<TryResult> tryResults) {
    this.tryResults = tryResults;
  }

  public void print() {
    tryResults.forEach( tryResult -> {
      System.out.print(tryResult.getName() + COLON);
      System.out.println(getHyphenDistance(tryResult.getPosition()));
    });
    printEmptyLine();
  }

  private void printEmptyLine() {
    System.out.println();
  }

  private String getHyphenDistance(int position) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < position; i++) {
      sb.append(HYPHEN);
    }
    return sb.toString();
  }
}
