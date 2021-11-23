package racingCar.view;

import java.util.List;
import racingCar.model.Position;
import racingCar.model.RacingCar;
import racingCar.model.RacingCars;

public class ResultView {

  private static final String STATUS_BAR = "-";
  private static final String SPLIT_CHARACTER = ",";
  private static final String FINALLY_WINNER_PATTERN = "%s가 최종 우승했습니다.";

  public void printAllCars(List<RacingCar> racingCars) {
    for (RacingCar car : racingCars) {
      System.out.printf("%s : %s%n", car.getName().getValue(), presentStatus(car.getPosition()));
    }
    System.out.println();
  }

  public String presentStatus(Position position) {
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < position.getValue(); i++) {
      sb.append(STATUS_BAR);
    }

    return sb.toString();
  }

  public void printWinner(RacingCars winners) {
    String combinedWinnerNames = appendWinnerName(winners);
    System.out.printf(FINALLY_WINNER_PATTERN, combinedWinnerNames);
  }

  public String appendWinnerName(RacingCars winners) {
    StringBuilder sb = new StringBuilder();

    for (RacingCar winner : winners.getAllCars()) {
      sb.append(winner.getName().getValue()).append(SPLIT_CHARACTER);
    }

    return sb.substring(0, sb.length() - 1);
  }
}
