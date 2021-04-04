package racingcar.result;

import java.util.List;
import racingcar.racing.Racing;

public class ResultView {

  private final Racing racing;
  private final static String POSITION_UNIT = "-";

  public ResultView(Racing racing) {
    this.racing = racing;
  }

  public void print() {
    System.out.println("실행 결과");
    List<Integer> currentSituations = racing.currentSituation();
    for (Integer currentSituation : currentSituations) {
      System.out.println(generateCarSituation(currentSituation));
    }
  }

  private String generateCarSituation(int position) {
    StringBuilder builder = new StringBuilder();
    for(int i = 0 ; i < position; ++i) {
      builder.append(ResultView.POSITION_UNIT);
    }
    return builder.toString();
  }
}
