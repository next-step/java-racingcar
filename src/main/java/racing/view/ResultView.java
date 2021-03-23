package racing.view;

import racing.domain.RacingCar;
import racing.domain.RacingCars;
import racing.domain.RacingRound;
import racing.domain.Winners;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

  private final static String ROUND_START_ALARM ="\nRound start";
  private final static String ROUND_STATUS_FORMAT = "%s : %s";
  private final static String CAR_MOVE_POSITION_SYMBOL = "-";
  private final static String WINNER_NAME_DELIMITER = ", ";
  private final static String WINNER_RESULT_FORMAT = "%s 최종 우승했습니다.";

  private ResultView() {
  }

  public static void print(List<RacingRound> racingRounds) {
    racingRounds.stream()
            .peek(round -> System.out.println(ROUND_START_ALARM))
            .map(RacingRound::racingCars)
            .map(RacingCars::getRacingCars)
            .flatMap(Collection::stream)
            .forEach(racingCar -> System.out.println(String.format(ROUND_STATUS_FORMAT, toCarNameString(racingCar), toPositionString(racingCar))));

    printWinner(racingRounds);
  }

  private static void printWinner(List<RacingRound> racingRounds) {
    racingRounds.stream()
            .filter(RacingRound::isFinalRound)
            .map(RacingRound::winners)
            .forEach(winners -> System.out.println(String.format(WINNER_RESULT_FORMAT, winnerNames(winners))));
  }

  private static String winnerNames(Winners winners) {
    return winners.getList().stream()
            .map(RacingCar::name)
            .collect(Collectors.joining(WINNER_NAME_DELIMITER));
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
