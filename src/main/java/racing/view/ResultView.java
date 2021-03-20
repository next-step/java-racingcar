package racing.view;

import racing.domain.RacingCar;
import racing.domain.RacingCars;
import racing.domain.RacingRound;

import java.util.Collection;
import java.util.List;

public class ResultView {

  private final static String ROUND_START_ALARM ="\nRound start";
  private final static String ROUND_STATUS_FORMAT = "%s : %s";
  private final static String CAR_MOVE_POSITION_SYMBOL = "-";

  private ResultView() {
  }

  public static void print(List<RacingRound> racingRounds) {
    racingRounds.stream()
            .peek(round -> System.out.println(ROUND_START_ALARM))
            .map(RacingRound::racingCars)
            .map(RacingCars::getRacingCars)
            .flatMap(Collection::stream)
            .forEach(racingCar -> System.out.println(String.format(ROUND_STATUS_FORMAT, toCarNameString(racingCar), toPositionString(racingCar))));
  }

  private static String toPositionString(RacingCar racingCar) {
    String positionString = "";
    for (int i = 0; i < racingCar.position(); i++) {
      positionString += CAR_MOVE_POSITION_SYMBOL;
    }
    return positionString;
  }

  private static String toCarNameString(RacingCar racingCar) {
    return racingCar.name();
  }
}
