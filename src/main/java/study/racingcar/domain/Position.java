package study.racingcar.domain;

import java.util.Objects;

public class Position {

  private static final int DEFAULT_START_POSITION = 0;

  private int position;

  public Position() {
    this(DEFAULT_START_POSITION);
  }

  public Position(final int position) {
    if (position < DEFAULT_START_POSITION) {
      throw new IllegalArgumentException("위치 값은 0 이상이어야 합니다.");
    }
    this.position = position;
  }

  public Position increase() {
    return new Position(this.position + 1);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Position position = (Position) o;
    return this.position == position.position;
  }

  @Override
  public int hashCode() {
    return Objects.hash(position);
  }

  public Position getMaxPosition(Position otherPosition) {
    if (this.position > otherPosition.position) {
      return this;
    }
    return otherPosition;
  }

  public int getPosition() {
    return position;
  }
}
