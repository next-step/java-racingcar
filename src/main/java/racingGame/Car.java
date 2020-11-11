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
    validateName(name);
    return new Car(0, name);
  }

  private static void validateName(String name) {
    validateNullString(name);
    validateOverLength(name);
  }

  private static void validateNullString(String name) {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException();
    }
  }

  private static void validateOverLength(String name) {
    if (name.length() > MAX_NAME_LENGTH) {
      throw new IllegalCarNameLengthException();
    }
  }

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
