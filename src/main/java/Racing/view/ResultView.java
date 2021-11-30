package Racing.view;

import static Racing.type.RacingString.DELIMITER;
import static Racing.type.RacingString.DISPLAY_TOKEN_STRING;
import static Racing.type.RacingString.joining;

import Racing.Race;
import Racing.type.RacingNumber;
import Racing.type.RacingString;
import java.util.List;

public class ResultView {

  public String draw(Race race) {
    List<List<RacingNumber>> history = race.getHistory();
    RacingString delimiter = DELIMITER.concat(DELIMITER);
    RacingString result = history
        .stream()
        .map(this::convertCarListToString)
        .collect(joining(delimiter));
    System.out.println("\n실행결과");
    return result.toString();
  }

  private RacingString convertCarListToString(List<RacingNumber> carListNumber) {
    return carListNumber.stream()
        .map(this::convertCarNumberToString)
        .collect(joining(DELIMITER));
  }

  private RacingString convertCarNumberToString(RacingNumber carNumber) {
    return carNumber.convertString(DISPLAY_TOKEN_STRING);
  }
}
