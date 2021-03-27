package racing.view;

import racing.domain.Name;
import racing.domain.RacingCar;
import racing.domain.RacingCars;
import racing.domain.RacingRound;
import racing.domain.Winners;
import racing.utils.StringUtils;

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
    return winners.winnerNames()
            .stream()
            .map(Name::getName)
            .collect(Collectors.joining(WINNER_NAME_DELIMITER));
  }

  private static String toPositionString(RacingCar racingCar) {
    return StringUtils.repeatString(CAR_MOVE_POSITION_SYMBOL, racingCar.position().getPosition());
  }

  private static String toCarNameString(RacingCar racingCar) {
    return racingCar.name().getName();
  }
}
