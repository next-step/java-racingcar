package racing.domain;


/**
 * 1. 자동차 (Car)
 *    - 상태
 *      - 위치
 *    - 책임
 *      - 전진 할 수 있다.
 *      - 멈출 수 있다.
 */
public class Car {

  private final String name;
  private int position;

  private final int MAX_NAME_LENGTH = 5;

  public Car(String name) {
    this.name = validateNameLength(name);
    this.position = 0;
  }

  private String validateNameLength(String name) {
    if (name.length() > MAX_NAME_LENGTH) {
      throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
    }
    return name;
  }

  public void move(MoveStrategy moveStrategy) {
    if (moveStrategy.isMovable()) {
      position++;
    }
  }


  public int position() {
    return position;
  }

  public String name() {
    return name;
  }
}
