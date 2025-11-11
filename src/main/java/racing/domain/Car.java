package racing.domain;
/**
 * 자동차
 * 1. 전진 & 멈추기
 * 2. 현재 위치 반환
 * */
public class Car {
  private int position;
  public Car(int position) {
    this.position = position;
  }

  public void move(int value){
    position += value;
  }

  public int getPosition() {
    return position;
  }

  public boolean isMove(int value) {
    // TODO
    return true;
  }
}
