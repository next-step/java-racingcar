package racingcar.view;

import racingcar.Cars;
import racingcar.Names;
import racingcar.Result;

public class ResultView {

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
}
