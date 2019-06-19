package racinggame.view;

import racinggame.model.RacingInfo;
import racinggame.util.StringUtil;

import java.util.List;

public class ResultView {
  public static void resultView(List<RacingInfo> result) {
    result.stream()
          .map(r -> StringUtil.getCarRacingPrint(r.getName(), r.getPosition()))
          .forEach(System.out::println);
  }

  public static void resultWinner(String winner) {
    System.out.println();
    System.out.println(winner + "가 최종우승했습니다.");
  }
}
