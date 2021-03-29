package racingcar;

public class RacingRule {

  private final int carCount;
  private final int tryCount;

  public RacingRule(int carCount, int tryCount) {
    if(carCount <= 0) {
      throw new IllegalArgumentException("자동차 대수는 0대보다 작을수 없습니다. 입력값 : " + carCount);
    }
    if(tryCount <= 0) {
      throw new IllegalArgumentException("시도 회수는 0보다 작을수 없습니다. 입력값 : " + tryCount);
    }
    this.carCount = carCount;
    this.tryCount = tryCount;
  }

  public int getCarCount() {
    return carCount;
  }

  public int getTryCount() {
    return tryCount;
  }

}
