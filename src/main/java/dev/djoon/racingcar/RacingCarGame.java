package dev.djoon.racingcar;

import dev.djoon.racingcar.actor.Car;
import dev.djoon.racingcar.actor.OppaCar;
import dev.djoon.racingcar.ui.ResultView;
import dev.djoon.racingcar.util.GameConstant;
import dev.djoon.racingcar.util.RandomNumbers;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

  private final List<Car> carList;
  private int loopTimes;

  public RacingCarGame(int carQuantity, int loopTimes) {
    carList = new ArrayList<>();
    fillCarList(carQuantity);

    this.loopTimes = loopTimes;
  }

  public void start(RandomNumbers random) {
    ResultView.printNewGame();
    for (int i = 0; i < loopTimes; i++) {
      carsMoveIfValid(random);

      ResultView.printCR();
    }
  }

  public List<Car> getCarList() {
    return carList;
  }

  private void carsMoveIfValid(RandomNumbers random) {
    for (Car car : carList) {
      int randomValue = random.nextInt(GameConstant.RANDOM_BOUNDARY);
      car.moveIfValidCondition(randomValue);

      ResultView.printXPos(car.getXPosition());
    }
  }

  private void fillCarList(int carQuantity) {
    for (int i = 0; i < carQuantity; i++) {
      carList.add(new OppaCar());
    }
  }

}
