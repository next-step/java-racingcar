package racing.ui;

import java.util.List;
import java.util.StringJoiner;
import racing.domain.Car;
import racing.domain.Participants;

public class ResultView {


  public static void printResultMessage() {
    System.out.println("\n" + Message.RESULT_MESSAGE.getMessage());
  }

  public static void printRoundResult(Participants participants) {
    System.out.println(participants);
  }

  public static void printWinner(List<String> winners) {
    StringJoiner joiner = new StringJoiner(",");
    for (String x : winners) {
      joiner.add(x);
    }
    System.out.println(joiner + "가 최종 우승했습니다.");
  }
}
