package racing.domain;

/**
 * 자동차 1. 전진 & 멈추기 2. 현재 위치 반환
 *
 */
public class Car {
  private final int MOVE_BORDER;

  private int position;

  public Car(){
    this(4, 0);
  }

  public Car(int position){
    this(4, position);
  }

  public Car(int moveBorder, int position) {
    this.MOVE_BORDER = moveBorder;
    this.position = position;
  }

  public void move(int value) {
    if (!isMove(value)) {
      return;
    }
    position += 1;
  }

  public int getPosition() {
    return position;
  }

  private boolean isMove(int value) {
    return value >= MOVE_BORDER;
  }
}
