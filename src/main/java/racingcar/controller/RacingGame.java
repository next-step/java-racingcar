package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.view.ResultView;

public class RacingGame {

  public List<Car> inputCars = new ArrayList<>();

  public void readyGame(String inputName) {
    String[] names = inputName.split(",");

    for (int i = 0; i < names.length; i++) {
      inputCars.add(new Car(names[i]));
    }
  }

  public void run(int attempt) {
    Cars cars = new Cars(inputCars);
    Movement move = new Movement();
    System.out.println("\n실행 결과");

    for (int i = 0; i < attempt; i++) {
      move.moveCars(inputCars);
      ResultView.showRacingResult(inputCars);
    }

    List<Car> winner = cars.getWinnerList();
    ResultView.showWinnerName(winner);
  }
}
