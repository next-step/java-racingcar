package racing.ui;

import java.util.List;
import java.util.StringJoiner;
import racing.dto.RacingResult;

public class ResultView {

  public static void printRoundResult(RacingResult racingResult) {
    if(racingResult.needsResultHeader()){
      System.out.println("\n" + Message.RESULT_MESSAGE.getMessage());
    }
    System.out.println(racingResult.getCurrentStatus());
  }

  public static void printWinners(List<String> winners) {
    StringJoiner joiner = new StringJoiner(",");
    for (String x : winners) {
      joiner.add(x);
    }
    System.out.println(joiner + "가 최종 우승했습니다.");
  }
}
