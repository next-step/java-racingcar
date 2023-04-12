package racing.domain;

import racing.util.RandomNumberGenerator;

/**
 * 1. 자동차 (Car)
 *    - 상태
 *      - 위치
 *    - 책임
 *      - 전진 할 수 있다.
 *      - 멈출 수 있다.
 */
public class Car {

  private int position;
  private final CarMoveCondition carMoveCondition;

  public Car() {
    this.position = 0;
    this.carMoveCondition = new CarMoveCondition();
  }

  public void move() {
    int randomNum = RandomNumberGenerator.generate();
    if (carMoveCondition.isMove(randomNum)) {
      position++;
    }
  }


  public int position() {
    return position;
  }
}
