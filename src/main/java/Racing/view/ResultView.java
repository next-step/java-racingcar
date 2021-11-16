package Racing.view;

import Racing.Race;
import Racing.stage.Stage;
import Racing.type.RacingString;
import java.util.Map;

public class ResultView {

  public String draw(Race race) {
    Map<Stage, RacingString> history = race.getHistory();
    RacingString concat = RacingString.DELIMITER.concat(RacingString.DELIMITER);
    RacingString collect = history.values().stream()
        .collect(RacingString.joining(concat));
    System.out.println("\n실행결과");
    return collect.toString();
  }
}
