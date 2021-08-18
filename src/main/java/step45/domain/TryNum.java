package step45.domain;

import java.util.Objects;

public class TryNum {

  private final int tryNum;

  public TryNum(int tryNum) {
    checkTryNum(tryNum);
    this.tryNum = tryNum;
  }

  public boolean isFinish() {
    return tryNum == 0;
  }

  public TryNum decrease() {
    return new TryNum(tryNum - 1);
  }

  private void checkTryNum(int tryNum) {
    if (tryNum < 0) {
      throw new IllegalArgumentException("음수값은 시도횟수가 될 수 없습니다.");
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TryNum tryNum1 = (TryNum) o;
    return tryNum == tryNum1.tryNum;
  }

  @Override
  public int hashCode() {
    return Objects.hash(tryNum);
  }
}
