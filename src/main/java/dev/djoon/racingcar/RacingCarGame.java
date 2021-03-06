package dev.djoon.racingcar;

import dev.djoon.racingcar.actor.Car;
import dev.djoon.racingcar.actor.OppaCar;
import dev.djoon.racingcar.ui.ResultView;
import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

  private List<Car> carList;
  private int loopTimes;
  private Condition condition;

  public RacingCarGame() {
    carList = new ArrayList<>();
    condition = Condition.RANDOM;
  }

  public void start() {
    ResultView.printNewGame();
    for (int i=0; i<loopTimes; i++) {
      for (Car car : carList) {
        carMoveIfValid(car);

        ResultView.printXPos(car.getXPos());
      }
      ResultView.printCR();
    }
  }

  public void carMoveIfValid(Car car) {
    if (condition.isValid())
      car.move();
  }

  public void setCarQuantity(int quantity) {
    for (int i=0; i<quantity; i++) {
      carList.add(new OppaCar());
    }
  }

  public List<Car> getCarList() {
    return carList;
  }

  public void setLoopTimes(int loopTimes) {
    this.loopTimes = loopTimes;
  }

  public void setCondition(Condition condition) {
    this.condition = condition;
  }

  // 테스트 용도 메소드
  public void setCondition(int conditionValue) {
    if (Condition.isValidValue(conditionValue)) {
      this.condition = Condition.ALWAYS;
      return;
    }
    this.condition = Condition.NEVER;
  }

}
