package racingcar;

public class Car {

  public static final int CONDITION_MOVE_NUMBER = 4;
  private int position;
  private String name;

  public Car(String carName) {
    this.name = carName;
  }

  public int move(int randomNumber) {
    if (isMovable(randomNumber)) {
      position++;
    }
    return position;
  }

  private boolean isMovable(int randomNumber) {
    return randomNumber >= CONDITION_MOVE_NUMBER;
  }

  public int getPosition() {
    return position;
  }

  public String getName() {
    return name;
  }
}
