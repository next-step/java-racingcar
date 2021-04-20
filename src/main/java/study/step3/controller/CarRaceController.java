package study.step3.controller;


import java.util.List;
import study.step3.domain.CarFactory;
import study.step3.domain.Cars;
import study.step3.domain.Car;
import study.step3.domain.GameRound;
import study.step3.view.ResultView;

public class CarRaceController {

  public CarRaceController() {
  }

  public List<Car> start(String[] names, int times) {
    Cars cars = CarFactory.makeCars(names);

    ResultView resultView = new ResultView();

    resultView.printRacingEndMessage();

    GameRound gameRound = new GameRound(times);

    while(!gameRound.isEnd()) {
      gameRound.reduceRound();

      cars.move();

      resultView.printPosition(cars);
    }

    String winners = cars.findWinners(times);

    resultView.printWinners(winners);

    return cars.getCars();
  }

}
