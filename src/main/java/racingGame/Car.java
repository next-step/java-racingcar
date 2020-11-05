package racingGame;

public class Car {

  private int position;

  Car() {
  }

  Car(int initialPosition) {
    this.position = initialPosition;
  }

  public int move(int delta) {
    position += delta;
    return this.position;
  }

  public int getPosition() {
    return position;
  }

}
