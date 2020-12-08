package step3.domain;

public class Car {

  private static final int INIT_POSITION = 1;
  private int distance;

  public Car() {
    this.distance = INIT_POSITION; // 최초 공백으로 나와, 결과값 구분이 어려워 기본값을 1로 셋팅
  }

  public void move() {
    this.distance++;
  }

  public int getDistance() {
    return this.distance;
  }
}
