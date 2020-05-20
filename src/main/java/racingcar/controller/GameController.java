package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.view.ResultView;

public class GameController {

  private int carNum;
  private int attemptNum;
  private Game game;

  private GameController(int carNum, int attemptNum) {
    this.carNum = carNum;
    this.attemptNum = attemptNum;
    this.game = Game.create(gameCars(this.carNum));
  }

  private List<Car> gameCars(int carNum) {
    List<Car> carList = new ArrayList<>();
    for (int i = 0; i < carNum; i++) {
      carList.add(Car.create("car " + i));
    }
    return carList;
  }

  public Game proceedGame() {
    for (int index = 0; index < this.attemptNum; index++) {
      game.doRace();
    }
    return this.game;
  }

  public ResultView getResults() {
    ResultView resultView = ResultView.create(this.game);
    return resultView.printView();
  }

  public int getCarNum() {
    return carNum;
  }

  public int getAttemptNum() {
    return attemptNum;
  }

  public Game getGame() {
    return game;
  }

  public static GameController create(int carNum, int attemptNum) {
    return new GameController(carNum, attemptNum);
  }
}
