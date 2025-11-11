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

  public boolean move(int value){
    if(!isMove(value)){
      return false;
    }
    position += 1;
    return true;
  }

  public int getPosition() {
    return position;
  }

  private boolean isMove(int value) {
    return value >= 4;
  }
}
