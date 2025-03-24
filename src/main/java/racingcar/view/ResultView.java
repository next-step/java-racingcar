package racingcar.view;

import java.util.List;
import racingcar.Car;
import racingcar.Cars;
import racingcar.Names;
import racingcar.Result;

public class ResultView {

  private static StringBuilder buildWinnerNames(List<Car> winners) {
    StringBuilder winnerNames = new StringBuilder();

    for (int i = 0; i < winners.size(); i++) {
      winnerNames.append(winners.get(i).getName());
      if (i < winners.size() - 1) {
        winnerNames.append(", ");
      }
    }
    return winnerNames;
  }

  public void showResult(Names names, Result result) {
    System.out.println("실행 결과");
    for (int i = 0; i < result.size(); i++) {
      printRound(names, result.getRoundResult(i));
    }
  }

  private void printRound(Names names, Cars cars) {
    for (int i = 0; i < cars.size(); i++) {
      System.out.println(names.getCarName(i) + " : " + cars.getCar(i).showPosition());
    }
    System.out.println();
  }

  public void showWinners(List<Car> winners) {
    StringBuilder winnerNames = buildWinnerNames(winners);
    System.out.println(winnerNames + "가 최종 우승했습니다.");
  }
}
