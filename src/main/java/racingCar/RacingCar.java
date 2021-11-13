package racingCar;

public class RacingCar {

  private int moveCount;

  public RacingCar(int moveCount) {
    this.moveCount = moveCount;
  }

  public void tryMove(int number) {
    if (!canMove(number)) {
      return;
    }
    this.moveCount++;
  }

  public int getMoveCount() {
    return moveCount;
  }

  private boolean canMove(int randomNumber) {
    return randomNumber >= 4;
  }
}
