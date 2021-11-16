package view;

import java.util.List;
import java.util.Map;
import racingCar.RacingCar;
import racingCar.RacingCars;

public class ResultView {

  private static final String STATUS_BAR = "-";
  private static final String FINALLY_WINNER_PATTERN = "%s가 최종 우승했습니다.";

  public void printAllCars(List<RacingCar> racingCars) {
    for (RacingCar car : racingCars) {
      System.out.printf("%s : %s%n", car.getName(), presentStatus(car.getMoveCount()));
    }
    System.out.println();
  }

  public String presentStatus(int moveCount) {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < moveCount; i++) {
      sb.append(STATUS_BAR);
    }

    return sb.toString();
  }

  public void printWinner(List<String> winnerNames) {
    String combinedWinnerNames = appendWinnerName(winnerNames);
    System.out.printf(FINALLY_WINNER_PATTERN, combinedWinnerNames);
  }

  public String appendWinnerName(List<String> winnerNames) {
    StringBuilder sb = new StringBuilder();

    for (String winnerName : winnerNames) {
      sb.append(winnerName).append(",");
    }

    return sb.substring(0, sb.length() - 1);
  }
}
