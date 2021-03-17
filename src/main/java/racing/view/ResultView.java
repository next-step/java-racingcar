package racing.view;

import racing.domain.RacingRound;

import java.util.Collection;
import java.util.List;

public class ResultView {

  private final static String ROUND_START_ALARM ="\nRound start";
  private final static String ROUND_STATUS_FORMAT = "%s : %s";
  private final static String CAR_MOVE_POSITION_SYMBOL = "-";
  private final static String CAR_NAME_FORMAT = "player %d";

  private ResultView() {
  }

  public static void print(List<RacingRound> racingRounds) {
    racingRounds.stream()
            .peek(round -> System.out.println(ROUND_START_ALARM))
            .map(RacingRound::getRacingCars)
            .flatMap(Collection::stream)
            .forEach(racingCar -> System.out.println(String.format(ROUND_STATUS_FORMAT, toCarNameString(racingCar.getCarNumber()), toPositionString(racingCar.getPosition()))));
  }

  private static String toPositionString(int position) {
    String positionString = "";
    for (int i = 0; i < position; i++) {
      positionString += CAR_MOVE_POSITION_SYMBOL;
    }
    return positionString;
  }

  private static String toCarNameString(int carNumber) {
    return String.format(CAR_NAME_FORMAT, carNumber);
  }
}
