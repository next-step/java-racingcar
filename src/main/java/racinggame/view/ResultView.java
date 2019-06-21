package racinggame.view;

import racinggame.domain.RacingInfo;
import racinggame.util.StringUtil;

import java.util.List;

public class ResultView {

  private static final String DELIMITER = ",";

  public static void resultView(List<RacingInfo> result) {
    result.stream()
          .map(r -> StringUtil.getCarRacingPrint(r.getName(), r.getPosition()))
          .forEach(System.out::println);
  }

  public static void resultWinner(List<String> winner) {
    System.out.println();
    System.out.println(joinWinner(winner) + "가 최종우승했습니다.");
  }

  private static String joinWinner(List<String> winner) {
    return String.join(DELIMITER, winner);
  }
}
