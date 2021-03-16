package racingcar.domain;

import java.util.Objects;

public class Position {

  public static final int DEFAULT_POSITION = 0;

  private final int position;

  public Position() {
    this(DEFAULT_POSITION);
  }

  public Position(int position) {
    if (position < DEFAULT_POSITION) {
      throw new IllegalArgumentException("위치는 양수여야 합니다.");
    }
    this.position = position;
  }

  public static Position max(Position maxPosition, Position position) {
    return new Position(Math.max(maxPosition.position, position.position));
  }

  public Position move() {
    return new Position(position + 1);
  }

  public boolean biggerThan(int number) {
    return number < position;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Position)) {
      return false;
    }
    Position position1 = (Position) o;
    return position == position1.position;
  }

  @Override
  public int hashCode() {
    return Objects.hash(position);
  }
}
