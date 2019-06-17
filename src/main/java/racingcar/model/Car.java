package racingcar.model;

import racingcar.util.RandomUtil;

public class Car {

  private static final int INITIAL_POSITION = 1;

  private int carNo;
  private int position;

  private RandomUtil random;


  public Car(int carNo, RandomUtil random) {
    this.carNo = carNo;
    this.position = INITIAL_POSITION;
    this.random = random;
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
    int value = random.nextInt();
    return value > 4;
  }

  public int getInitialPosition() {
    return INITIAL_POSITION;
  }

  public int getPosition() {
    return position;
  }
}
