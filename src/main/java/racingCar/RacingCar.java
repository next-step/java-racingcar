package racingCar;

import java.util.Random;

public class RacingCar {

  private int moveCount;

  public RacingCar() {
    this.moveCount = 0;
  }

  public void tryMove(int randomNumber) {
    if (!canMove(randomNumber)) {
      return;
    }
    this.moveCount++;
  }

  public int getMoveCount() {
    return moveCount;
  }

  public boolean canMove(int randomNumber) {
    return randomNumber >= 4;
  }
}
