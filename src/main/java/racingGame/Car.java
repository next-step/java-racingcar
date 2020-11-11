package racingGame;

import racingGame.racingGameException.IllegalCarNameLengthException;

public class Car {

  private static final int MAX_NAME_LENGTH = 5;

  private int position;
  private final String name;

  private Car(int initialPosition, String name) {
    this.position = initialPosition;
    this.name = name;
  }

  static public Car of(String name) {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException();
    }

    if (name.length() > MAX_NAME_LENGTH) {
      throw new IllegalCarNameLengthException();
    }

    return new Car(0, name);
  }

  // Car를 생성할 때 어떻게 움직일지 결정 해놓는다?
  public int move(int delta) {
    position += delta;
    return this.position;
  }

  public int getPosition() {
    return this.position;
  }

  public String getName() {
    return this.name;
  }
}
