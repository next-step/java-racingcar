package carracing.domain;

public class Car {

  private int nowStep;
  private int moveCount;

  private static final String NO_MORE_CHANCE_MESSAGE = "더 이상 진행할 수 없습니다.";

  public Car(int nowStep, int moveCount) {
    this.nowStep = nowStep;
    this.moveCount = moveCount;
  }

  public void plusNowStep() {
    this.nowStep++;
  }

  public void minusMoveCount() {
    if (this.moveCount <= 0) {
      throw new IllegalStateException(NO_MORE_CHANCE_MESSAGE);
    }
    this.moveCount--;
  }

  public int getNowStep() {
    return nowStep;
  }

  public int getMoveCount() {
    return moveCount;
  }

}
