package racing.model;

import java.util.List;

public class RacingCar {

  private int position;

  public RacingCar(int position) {
    this.position = position;
  }

  public int getPosition() {
    return position;
  }

  public int move(int moveCount) {
    if (isForward(moveCount)) {
      this.position += moveCount;
    }
    return position;
  }

  public boolean isForward(int moveCount) {
    return moveCount > 3;
  }
}
