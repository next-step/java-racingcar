package Racing.view;

import static Racing.type.RacingString.DELIMITER;
import static Racing.type.RacingString.DISPLAY_TOKEN_STRING;
import static Racing.type.RacingString.joining;

import Racing.Race;
import Racing.stage.Stage;
import Racing.type.RacingNumber;
import Racing.type.RacingString;
import java.util.List;
import java.util.Map;

public class ResultView {

  public String draw(Race race) {
    Map<Stage, List<RacingNumber>> history = race.getHistory();
    RacingString delimiter = DELIMITER.concat(DELIMITER);
    RacingString result = history.values()
        .stream()
        .map((carListNumber) -> convertCarListToString(carListNumber))
        .collect(joining(delimiter));
    System.out.println("\n실행결과");
    return result.toString();
  }

  private RacingString convertCarListToString(List<RacingNumber> carListNumber) {
    return carListNumber.stream()
        .map(carNumber -> convertCarNumberToString(carNumber))
        .collect(joining(DELIMITER));
  }

  private RacingString convertCarNumberToString(RacingNumber carNumber) {
    return carNumber.convertString(DISPLAY_TOKEN_STRING);
  }
}
