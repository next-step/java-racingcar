package racingcar.model;

import racingcar.util.drivingStrategy.DrivingStrategy;
import racingcar.util.drivingStrategy.RandomStrategy;

public class Car {

  private static final int INITIAL_POSITION = 1;

  private int carNo;
  private String name;
  private int position;

  private DrivingStrategy drivingStrategy;

  public Car(int carNo) {
    this.carNo = carNo;
    this.position = INITIAL_POSITION;
    this.drivingStrategy = RandomStrategy.getInstance();
  }

  public Car(String name) {
    this.name = name;
    this.position = INITIAL_POSITION;
    this.drivingStrategy = RandomStrategy.getInstance();
  }

  public Car(String name, DrivingStrategy strategy) {
    this.name = name;
    this.position = INITIAL_POSITION;
    this.drivingStrategy = strategy;
  }

  /**
   * test시 mocking을 위한 setter
   * @param drivingStrategy
   */
  public void setDrivingStrategy(DrivingStrategy drivingStrategy) {
    this.drivingStrategy = drivingStrategy;
  }

  /**
   * 현재 위치 + 1
   */
  public void move() {
    if (enableMoveForward()) this.position += 1;
  }

  /**
   * 경주가 끝난 후 새로운 경주를 하기 전에 position reset
   */
  public void resetPosition() {
    this.position = INITIAL_POSITION;
  }

  /**
   * random 값이 4 이상이면 true 반환
   * @return
   */
  private boolean enableMoveForward() {
    int value = drivingStrategy.throwDice();
    return value > 4;
  }

  public int getInitialPosition() {
    return INITIAL_POSITION;
  }

  public int getPosition() {
    return position;
  }

  public String getName() { return name; }

  @Override
  public String toString() {
    return name;
  }
}
