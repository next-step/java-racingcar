package racingcar.view;

import racingcar.Cars;
import racingcar.Result;

public class ResultView {

  public void showResult(Result result) {
    System.out.println("실행 결과");
    for (int i = 0; i < result.size(); i++) {
      printRound(result.getRoundResult(i));
    }
  }

  private void printRound(Cars cars) {
    for (int i = 0; i < cars.size(); i++) {
      System.out.println(cars.getCar(i).showPosition());
    }
    System.out.println();
  }
}
