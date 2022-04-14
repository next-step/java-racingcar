package racingcar.model;

public class Car {

  private static final int MOVE_BOUND = 4;

  private int position;

  public Car(int position) {
    this.position = position;
  }

  public Car() {
    this(0);
  }

  public int getPosition() {
    return position;
  }

  public void moveOrStop(int randomNumber) {
    if (movePossible(randomNumber)) {
      position++;
    }
  }

  private boolean movePossible(int randomNumber) {
    return randomNumber >= MOVE_BOUND;
  }
}
