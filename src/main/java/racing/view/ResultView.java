package racing.view;

import racing.domain.RacingRound;

import java.util.Collection;
import java.util.List;

public class ResultView {

  private ResultView() {
  }

  public static void print(List<RacingRound> racingRounds) {
    racingRounds.stream()
            .peek(round -> System.out.println("\nround start"))
            .map(RacingRound::getRacingCars)
            .flatMap(Collection::stream)
            .forEach(racingCar -> System.out.println(String.format("%s : %s", toCarNameString(racingCar.getCarNumber()), toPositionString(racingCar.getPosition()))));
  }

  private static String toPositionString(int position) {
    String positionString = "";
    for (int i = 0; i < position; i++) {
      positionString += "-";
    }
    return positionString;
  }

  private static String toCarNameString(int carNumber) {
    return "player " + carNumber;
  }
}
