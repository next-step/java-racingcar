package racinggame.domain;

import javafx.util.Pair;
import racinggame.racinggamexception.IllegalCarNameLengthException;

public class Car {

  private static final int MAX_NAME_LENGTH = 5;
  private static final int CAR_INITIAL_POSITION = 0;

  private int position;
  private final String name;

  private Car(String name, int initialPosition) {
    this.name = name;
    this.position = initialPosition;
  }

  static public Car of(String name) {
    return of(name, 0);
  }

  static public Car of(String name, int initialPosition) {
    validateName(name);
    validateInitialPosition(initialPosition);
    return new Car(name, initialPosition);
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

  private static void validateInitialPosition(int initialPosition) {
    if (initialPosition < CAR_INITIAL_POSITION) {
      throw new IllegalArgumentException();
    }
  }

  public int move(ScoreGenerator scoreGenerator) {
    position += scoreGenerator.generateScore();
    return this.position;
  }

  public String getName() {
    return this.name;
  }

  public int renewWinner(int candidatePosition) {
    return Math.max(position, candidatePosition);
  }

  public boolean isWinner(int furthestPosition) {
    return this.position == furthestPosition;
  }

  public boolean isLocatedOn(int position) {
    return isWinner(position);
  }

  public Pair<String, Integer> publishNamePosition() {
    return new Pair<>(this.name, this.position);
  }
}
