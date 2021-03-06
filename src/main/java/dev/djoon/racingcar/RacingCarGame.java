package dev.djoon.racingcar;

import dev.djoon.racingcar.actor.Car;
import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

  private List<Car> carList;
  private int loopTimes;
  private Condition condition;
  private int[] winNumbers;

  public RacingCarGame() {
    carList = new ArrayList<>();
    condition = Condition.NEVER;
  }

  public void start() {
  for (int i=0; i<loopTimes; i++) {
      for (Car car : carList) {
        if (condition.isValid())
          car.move();
      }
    }
  }


  public void addCar(Car car) {
    carList.add(car);
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

  public void setCondition(int conditionValue) {
    if (Condition.isValidValue(conditionValue))
      this.condition = Condition.ALWAYS;
  }

}
