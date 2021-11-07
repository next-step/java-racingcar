package carracing.domain;

public class Car {

  private int nowStep;
  private int moveCount;
  private final int originMoveCount;

  private static final int INIT_COUNT = 1;

  private static final String NO_MORE_MOVE_MESSAGE = "더 이상 이동할 수 없습니다.";
  private static final String NO_MORE_CHANCE_MESSAGE = "더 이상 게임을 진행할 수 없습니다.";

  public Car(int moveCount) {
    this.nowStep = INIT_COUNT;
    this.moveCount = moveCount;
    this.originMoveCount = moveCount;
  }

  public void plusNowStep() {
    if (this.nowStep >= originMoveCount + INIT_COUNT) {
      throw new IllegalStateException(NO_MORE_MOVE_MESSAGE);
    }

    if (this.moveCount <= 0){
      throw new IllegalStateException(NO_MORE_MOVE_MESSAGE);
    }
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
