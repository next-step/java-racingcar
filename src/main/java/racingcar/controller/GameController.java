package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Game;
import racingcar.view.ResultView;

public class GameController {

  private int attemptNum;
  private Game game;

  private GameController(Integer attemptNum, String[] names) {
    this.attemptNum = attemptNum;
    this.game = Game.create(gameCars(names));
  }

  private Cars gameCars(String[] names) {
    List<Car> cars = new ArrayList<>();
    for (String name : names) {
      cars.add(Car.create(name));
    }
    return Cars.create(cars);
  }

  public Game proceedGame() {
    for (int index = 0; index < this.attemptNum; index++) {
      game.doRace();
    }
    return this.game;
  }

  public void getResults() {
    ResultView resultView = ResultView.create(this.game);
    resultView.printView();
  }

  public int getAttemptNum() {
    return attemptNum;
  }

  public Game getGame() {
    return game;
  }

  public static GameController create(int attemptNum, String[] names) {
    return new GameController(attemptNum, names);
  }
}
