package racingcar;

public class Car {
  private final long id;
  private int position;

  public Car(long id) {
    this.id = id;
    this.position = 0;
  }

  public void move() {
    position++;
  }

  public int getPosition() {
    return position;
  }

  public long getId() {
    return id;
  }
}
