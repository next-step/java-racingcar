package dev.djoon.racingcar;

import dev.djoon.racingcar.actor.Car;
import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {

  private List<Car> carList;
  private int loopTimes;
  private int conditionValue;
  private Condition condition;

  public RacingCarGame() {
    carList = new ArrayList<>();
  }

  public void start() {
    for (int i=0; i<loopTimes; i++) {
      for (Car car : carList) {
        if (condition.getValue() >= 4)
          car.move();
      }
    }
  }

  public void setConditionValue(int conditionValue) {
    this.conditionValue = conditionValue;
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
}
