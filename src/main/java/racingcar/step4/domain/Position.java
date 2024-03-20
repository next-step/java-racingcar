package racingcar.step4.domain;

import java.util.Objects;

public class Position implements Comparable<Position> {

  public static final String CAR_POSITION_CAN_NOT_BE_NEGATIVE = "자동차 위치는 음수가 될 수 없습니다.";
  public static final int DEFAULT_START_POSITION = 0;
  private int position;

  private Position(int position) {
    this.position = position;
  }

  public static Position defaultPosition() {
    return new Position(DEFAULT_START_POSITION);
  }

  public static Position specificPosition(int position) {
    validate(position);
    return new Position(position);
  }

  public Position copy() {
    return new Position(position);
  }

  public Boolean isSame(Position position) {
    return this.position == position.position;
  }

  public void forward() {
    this.position += 1;
  }

  public int getPosition() {
    return position;
  }

  private static void validate(int position) {
    if (position < 0) {
      throw new IllegalArgumentException(CAR_POSITION_CAN_NOT_BE_NEGATIVE);
    }
  }

  @Override
  public int compareTo(Position o) {
    return this.position - o.position;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Position position1 = (Position) o;
    return position == position1.position;
  }

  @Override
  public int hashCode() {
    return Objects.hash(position);
  }
}
