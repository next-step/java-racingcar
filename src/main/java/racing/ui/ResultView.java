package racing.ui;

import java.util.List;
import java.util.StringJoiner;
import racing.domain.Car;
import racing.domain.Participants;

public class ResultView {

  private static final String POSITION_MARKER = "-";

  public static void printResultMessage() {
    System.out.println("\n" + Message.RESULT_MESSAGE.getMessage());
  }

  public static void printRoundResult(Participants participants) {
    for (Car car : participants.getCars()) {
      System.out.println(
          car.getName() + " : " + POSITION_MARKER.repeat(car.getPosition().getPosition()));
    }
    System.out.println();
  }

  public static void printWinner(List<String> winners) {
    StringJoiner joiner = new StringJoiner(",");
    for (String x : winners) {
      joiner.add(x);
    }
    System.out.println(joiner + "가 최종 우승했습니다.");
  }
}
