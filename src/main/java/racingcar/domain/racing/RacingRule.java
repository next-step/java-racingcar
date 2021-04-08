package racingcar.domain.racing;

import java.util.List;

public class RacingRule {

  private final int carCount;
  private final int tryCount;
  private final List<String> carNameList;

  public RacingRule(List<String> carNameList, int tryCount) {
    validCarCount(carNameList.size());
    validTryCount(tryCount);
    this.carCount = carNameList.size();
    this.tryCount = tryCount;
    this.carNameList = carNameList;
  }

  public void validCarCount(int carCount) {
    if (carCount <= 0) {
      throw new IllegalArgumentException("자동차 대수는 0대보다 작을수 없습니다. 입력값 : " + carCount);
    }
  }

  public void validTryCount(int tryCount) {
    if (tryCount <= 0) {
      throw new IllegalArgumentException("시도 회수는 0보다 작을수 없습니다. 입력값 : " + tryCount);
    }
  }

  public int getCarCount() {
    return this.carCount;
  }

  public int getTryCount() {
    return this.tryCount;
  }

  public List<String> getCarNameList() {
    return this.carNameList;
  }

}
