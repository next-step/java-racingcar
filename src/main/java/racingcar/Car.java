package racingcar;

import java.util.Random;

public class Car {

  private int position;
  private static final String POSITION_UNIT = "-";

  public Car() {
    this.position = 0;
  }

  private void moveOne() {
    this.position++;
  }

  public void tryMove() {
    int moveDecisionNum = this.generateMoveNum();
    if (this.isCanMove(moveDecisionNum)) {
      moveOne();
    }
  }

  public int generateMoveNum() {
    Random random = new Random();
    return random.nextInt();
  }

  public int getPosition() {
    return this.position;
  }

  private boolean isCanMove(int moveDecisionNum) {
    return moveDecisionNum >= 4;
  }

  public String getPositionString() {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = 0; i < position; ++i) {
      stringBuilder.append(POSITION_UNIT);
    }
    return stringBuilder.toString();
  }
}
