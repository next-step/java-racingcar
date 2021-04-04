package racingcar.result;

import java.util.List;
import racingcar.racing.Racing;

public class ResultView {

  private final Racing racing;
  private final static String POSITION_UNIT = "-";

  public ResultView(Racing racing) {
    this.racing = racing;
  }

  public void printPreRacing() {
    System.out.println();
    System.out.println("실행 결과");
  }

  public void printNow() {
    List<CarResultView> carResultViews = racing.currentSituation();
    for (CarResultView currentSituation : carResultViews) {
      System.out.println(currentSituation.generateCurrentSituation(POSITION_UNIT));
    }
  }

  public void printWinner() {
    List<String> winnerCarName = racing.getWinnerCarName();
    String winnerJoinList = String.join(", ", winnerCarName);
    System.out.println(winnerJoinList+"가 최종 우승했습니다.");
  }
}
