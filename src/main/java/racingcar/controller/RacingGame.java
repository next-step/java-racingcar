package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.view.ResultView;

public class RacingGame {

  public List<Car> cars = new ArrayList<>();

  public void readyGame(String inputName) {
    String[] names = inputName.split(",");

    for (int i = 0; i < names.length; i++) {
      cars.add(new Car(names[i]));
    }
  }

  public void run(int attempt) {
    Movement move = new Movement();
    Winner win = new Winner();
    System.out.println("\n실행 결과");

    for (int i = 0; i < attempt; i++) {
      move.moveCars(cars);
      ResultView.showRacingResult(cars);
    }

    win.decideWinner(cars);
    ResultView.showWinnerName(win.cars);
  }
}
