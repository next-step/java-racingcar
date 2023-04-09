package racing;

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

  public Car() {
    this.position = 0;
  }

  public void move() {
    this.position++;
  }


  public int position() {
    return position;
  }
}
