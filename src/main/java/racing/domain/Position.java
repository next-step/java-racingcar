package racing.domain;

import java.util.Objects;
import racing.exception.ErrorMessage;
import racing.exception.RacingException;

public class Position implements Comparable<Position> {

  private static final String POSITION_MARKER = "-";
  private int position;

  public Position(){
    this(0);
  }

  public Position(int position) {
    if (position < 0) {
      throw new RacingException(PositionMessage.INVALID_CAR_INIT_POSITION);
    }
    this.position = position;
  }

  public void increase() {
    this.position += 1;
  }

  @Override
  public int compareTo(Position o) {
    return this.position - o.position;
  }

  @Override
  public boolean equals(Object o) {
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Position position1 = (Position) o;
    return position == position1.position;
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(position);
  }

  @Override
  public String toString() {
    return POSITION_MARKER.repeat(this.position);
  }

  static class PositionMessage extends ErrorMessage {

    public static final PositionMessage INVALID_CAR_INIT_POSITION =
        new PositionMessage("자동차의 위치는 0부터 시작합니다");

    private PositionMessage(String message) {
      super(message);
    }
  }
}
