package racingCar;

public class RacingCar implements Comparable<RacingCar> {

  private int moveCount;
  private String name;

  public RacingCar(int moveCount, String name) {
    this.moveCount = moveCount;
    this.name = name;
  }

  public void tryMove(int number) {
    if (!canMove(number)) {
      return;
    }
    this.moveCount++;
  }

  private boolean canMove(int randomNumber) {
    return randomNumber >= 4;
  }

  public int getMoveCount() {
    return moveCount;
  }

  public String getName() {
    return name;
  }

  @Override
  public int compareTo(RacingCar racingCar) {
    return moveCount - racingCar.getMoveCount();
  }
}
