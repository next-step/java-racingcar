package racingCar.domain;

public class TryCount {

  private int tryCount;

  public TryCount(int tryCount) {
    this.tryCount = tryCount;
  }

  public void race() {
    if (tryCount <= 0) {
      throw new AlreadyEndRaceException("이미 경기가 끝났습니다");
    }
    tryCount--;
  }

  public boolean isMoreZero() {
    return tryCount > 0;
  }
}
