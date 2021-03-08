package dev.djoon.racingcar;

import dev.djoon.racingcar.actor.Car;
import dev.djoon.racingcar.ui.ResultView;
import dev.djoon.racingcar.util.GameConstant;
import dev.djoon.racingcar.util.RandomNumbers;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

  private final List<Car> carList;
  private final int loopTimes;
  private int winnerScore = 0;

  public RacingCarGame(int carQuantity, int loopTimes) {
    carList = new ArrayList<>();
    fillCarList(carQuantity);

    this.loopTimes = loopTimes;
  }

  public RacingCarGame(String[] ownerNames, int loopTimes) {
    carList = new ArrayList<>();
    fillCarList(ownerNames);

    this.loopTimes = loopTimes;
  }

  public void start(RandomNumbers random) {
    ResultView.printNewGame();
    for (int i = 0; i < loopTimes; i++) {
      carsMoveIfValid(random);

      ResultView.printCR();
    }
    ResultView.printWinner(findWinners());
  }

  public List<Car> getCarList() {
    return carList;
  }

  public List<Car> findWinners() {
    findWinnerScore();

    List<Car> winners = new ArrayList<>();
    for (Car car : carList) {
      checkIfWinner(winners, car);
    }

    return winners;
  }

  private void checkIfWinner(List<Car> winners, Car car) {
    if (winnerScore == car.getXPosition()) {
      winners.add(car);
    }
  }

  private void findWinnerScore() {
    for (Car car : carList) {
      winnerScore = Math.max(winnerScore, car.getXPosition());
    }
  }

  private void carsMoveIfValid(RandomNumbers random) {
    for (Car car : carList) {
      int randomValue = random.nextInt(GameConstant.RANDOM_BOUNDARY);
      car.moveIfValidCondition(randomValue);

      ResultView.printCarOwner(car);
      ResultView.printXPos(car.getXPosition());
    }
  }

  private void fillCarList(int carQuantity) {
    for (int i = 0; i < carQuantity; i++) {
      carList.add(RacingCarFactory.create());
    }
  }

  private void fillCarList(String[] ownerNames) {
    for (String ownerName : ownerNames) {
      carList.add(RacingCarFactory.createWithOwner(ownerName));
    }
  }

}
