package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Game;
import racingcar.util.RandomUtil;

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

  public Integer proceedGame() {
    int index = 0;
    for (; index < this.attemptNum; index++) {
      int random = RandomUtil.getRandomValue();
      game.doRace(random);
    }
    return index;
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
